#include "./fat.h"
#include "./fdc.h"
#include <stddef.h>
#include "./string.h"

// FAT Copies
// First copy is fat0 stored at 
// Second copy is fat1
// There were issues declaring the FATs as non-pointers
// When they would get read from floppy, it would overwrite wrong areas of memory
fat_t *fat0;
fat_t *fat1;
void *startAddress = (void *) 0x20000;

// Initialize the file system
// Loads the FATs and root directory
void init_fs(directory_t *directory)
{
    // The FATs and directory are loaded into 0x20000, 0x21200, and 0x22400
    // These addresses were chosen because they are far enough away from the kernel (0x01000 - 0x07000)

    // Read the first copy of the FAT (Drive 0, Cluster 1, 512 bytes * 9 clusters)
    fat0 = (fat_t *) startAddress; // Put FAT at 0x20000
    floppy_read(0, 1,  (void *)fat0, sizeof(fat_t));

    // Read the second copy of the FAT (Drive 0, Cluster 10, 512 bytes * 9 clusters)
    fat1 = (fat_t *) (startAddress+sizeof(fat_t)); // Put FAT at 0x21200
    floppy_read(0, 10, (void *)fat1, sizeof(fat_t));

    // Read the root directory (Drive 0, Cluster 19, 512 bytes * 14 clusters)
    directory->startingAddress = (uint8 *) (startAddress+(sizeof(fat_t)*2)); // Put ROOT at 0x22400
    floppy_read(0, 19, (void *)directory->startingAddress, 512 * 14);

    directory->entry.filename[0] = 'R';
    directory->entry.filename[1] = 'O';
    directory->entry.filename[2] = 'O';
    directory->entry.filename[3] = 'T';
}

void closeFile(file_t *file)
{
    if (file != NULL || file->isOpened == 1)
    {
        uint16 current = file->entry.startingCluster;
        uint32 index = 0;
        uint32 remainingSize = file->entry.fileSize;

        while (remainingSize > 0)
        {
            // Write file contents to storage
            floppy_write(0, 33 + (current - 2), (void *)(file->startingAddress + index), 512);
            index += 512; // Offset by a sector of data
            remainingSize -= 512; // Remove a sector of bytes

            // If no more data to write and at EOF
            if (remainingSize > 0 && fat0->entries[current] == 0xFFFF)
            {
                // Go through all clusters
                for (uint16 i=2; i<2304; i++)
                {
                    // If empty cluster
                    if (fat0->entries[i] == 0x0000)
                    {
                        fat0->entries[current] = i;      // Save cluster addr to current cluster
                        current = i;                     // Set free cluster as current cluster
                        fat0->entries[current] = 0xFFFF; // Mark EOF (the free cluster now EOF)
                        break;
                    }
                }
            }
            else {
                current = fat0->entries[current]; // Set current as new cluster
            }
        }

        file->isOpened = 0; // Make file open false (closed)

    } else {
        return; // Cannot close file, just return
    }
}

int openFile(file_t *file)
{
    if (file != NULL || file->entry.startingCluster != 0)
    {
        uint16 current = file->entry.startingCluster;
        uint32 index = 0;
        file->startingAddress = (uint8 *)0x30000; 

        // If not EOF, load more data
        while (current != 0xFFFF)
        {
            floppy_read(0, 33 + (current - 2), (void *)(file->startingAddress + index), 512);
            index += 512; // Offset for next sector of data
            current = fat0->entries[current]; // Get next cluster
        }

        file->isOpened = 1; // Make file open true

    } else {
        return -1;
    }
    return 0;
}

// Creates an empty file and writes it to the floppy disk
// You can see the effects of calling this function by viewing your OS image in a hex editor
// Your OS image will be updated to contain the following:
// FAT Tables changes:
// 0x0266 - 0x0267: 0xFFFF (FAT entry) (First FAT table)
// 0x1466 - 0x1467: 0xFFFF (FAT entry) (Second FAT table)
// Root Directory changes:
// 0x2620 - 0x263F: Directory entry for our new file (contains filename, extension, startingCluster, filesize, etc.)
// File changes:
// 0xA400 - 0xA5FF: Our file (1 sector) contains either 0's or "Hello World!\n"
int createFile(file_t *file, directory_t *parent)
{
    // IFF file and parent exists
    if (file != NULL && parent != NULL && parent->entry.startingCluster != 0)
    {
        directory_entry_t *entry = (directory_entry_t *)parent->startingAddress;

        // Find directory entry to save to
        while (entry->filename[0] != 0)
        {
            entry++;
        }

        stringcopy((char *)file->entry.filename, (char *)entry->filename, 8);   // Filenames are 8 characters
        stringcopy((char *)file->entry.extension, (char *)entry->extension, 3); // Extensions are 3 chars

        // Set up metadata for new file
        entry->attributes = 0x00;   // Normal file code
        entry->fileSize = 0;        // 0 because no data stored
        
        for (uint16 i=2; i<2304; i++)
        {
            if (fat0->entries[i] == 0x0000) // If cluster is free/empty
            {
                entry->startingCluster = i;     // Set starting cluster to i (free cluster)
                fat0->entries[i] = 0xFFFF;   // Mark cluster as EOF (because no data stored yet)
                break;
            }
        }

        closeFile(file);                // Close file (not in use, just created)
    } else {
        return -1; // No file or parent directory found
    }

    return 0;
}

void deleteFile(file_t *file, directory_t *parent)
{
    if (file != NULL && parent != NULL && parent->entry.startingCluster != 0)
    {
        uint16 current = file->entry.startingCluster;   // get cluster of file

        // Loop thru clusters until EOF (Last cluster)
        while (current != 0xFFFF)
        {
            uint16 next = fat0->entries[current];       // entries[cluster] has next cluster #
            fat0->entries[current] = 0x0000;            // Make cluster empty
            current = next;
        }

        // Sync FAT1 with FAT0
        for (uint16 i=0; i<2304; i++)
            fat1->entries[i] = fat0->entries[i];

        // Updating parent directory by removing directory entry as per instruction
        directory_entry_t *entry = (directory_entry_t *)parent->startingAddress;
        while (entry->filename[0] != 0)
        {
            // Check if filename and extension match
            // Extension is needed because test.py != test.txt, they're different files
            if (stringcompare((char *)entry->filename, (char *)file->entry.filename, 8) && stringcompare((char *)entry->extension, (char *)file->entry.extension, 3))
            {
                entry->filename[0] = 0; // Setting name as 0
                break;
            }
            entry++;
        }

    } else {
        return; // File or parent directory not found
    }
}

// Returns a byte from a file that is currently loaded into memory
// This does NOT modify the floppy disk
// This function requires the file to have been loaded into memory with floppy_read()
uint8 readByte(file_t *file, uint32 index)
{
    if (file != NULL && file->isOpened)
        return *((uint8 *)(file->startingAddress + index));
    return 0;
}

// Writes a byte to a file that is currently loaded into memory
// This does NOT modify the floppy disk
// To write this to the floppy disk, we have to call floppy_write()
int writeByte(file_t *file, uint8 byte, uint32 index)
{
    if (!file->isOpened)
    {
        return -1; //File not opened
    }

    *((uint8 *)(file->startingAddress + index)) = byte; // Add bye to index
    file->entry.fileSize++;                              // Update file size

    return 0;
}

int findFile(char *filename, char* ext, directory_t directory, directory_entry_t *foundEntry)
{
	directory_entry_t *entry = (directory_entry_t *)directory.startingAddress;

	while(entry->filename[0] != 0)
	{
		int fileExists = stringcompare((char *)entry->filename, filename, 8) && stringcompare((char *)entry->extension, ext, 3);
		
		if(fileExists)
		{
			*foundEntry = *entry;
			return 1;
		}

		entry++;
	}

	return 0;
}