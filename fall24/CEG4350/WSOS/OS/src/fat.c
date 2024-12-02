#include "./fat.h"
#include "./fdc.h"

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

}

int openFile(file_t *file)
{
    startAddress = file->startingAddress;
    uint16 currentCluster = file->entry->startingCluster;
    
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
    return -1;
}

void deleteFile(file_t *file, directory_t *parent)
{

}

// Returns a byte from a file that is currently loaded into memory
// This does NOT modify the floppy disk
// This function requires the file to have been loaded into memory with floppy_read()
uint8 readByte(file_t *file, uint32 index)
{
    return -1;
}

// Writes a byte to a file that is currently loaded into memory
// This does NOT modify the floppy disk
// To write this to the floppy disk, we have to call floppy_write()
int writeByte(file_t *file, uint8 byte, uint32 index)
{
    return -1;
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