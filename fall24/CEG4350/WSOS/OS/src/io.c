#include "./io.h"
#include "./types.h"

// Track the current cursor's row and column
volatile int cursorCol = 0;
volatile int cursorRow = 0;

// Define a keymap to convert keyboard scancodes to ASCII
char keymap[128] = {};

// C version of assembly I/O port instructions
// Allows for reading and writing with I/O
// The keyboard status port is 0x64
// The keyboard data port is 0x60
// More info here:
// https://wiki.osdev.org/I/O_Ports
// https://wiki.osdev.org/Port_IO
// https://bochs.sourceforge.io/techspec/PORTS.LST

// outb (out byte) - write an 8-bit value to an I/O port address (16-bit)
void outb(uint16 port, uint8 value)
{
    asm volatile ("outb %1, %0" : : "dN" (port), "a" (value));
	return;
}

// outw (out word) - write an 16-bit value to an I/O port address (16-bit)
void outw(uint16 port, uint16 value)
{
    asm volatile ("outw %1, %0" : : "dN" (port), "a" (value));
	return;
}

// inb (in byte) - read an 8-bit value from an I/O port address (16-bit)
uint8 inb(uint16 port)
{
   uint8 ret;
   asm volatile("inb %1, %0" : "=a" (ret) : "dN" (port));
   return ret;
}

// inw (in word) - read an 16-bit value from an I/O port address (16-bit)
uint16 inw(uint16 port)
{
   uint16 ret;
   asm volatile ("inw %1, %0" : "=a" (ret) : "dN" (port));
   return ret;
}

// Setting the cursor does not display anything visually
// Setting the cursor is simply used by putchar() to find where to print next
// This can also be set independently of putchar() to print at any x, y coordinate on the screen
int setcursor(int x, int y)
{	
    int maxWidth = 79;
    int maxHeight = 24;

    cursorCol = cursorNum(x, maxWidth);
    cursorRow = cursorNum(y, maxHeight);

	return 0;
}

int cursorNum(int num, int maxNum) 
{
    int cursor = num;
    while (num > maxNum) {
        cursor = (num % maxNum) - 1;
        num = cursor;
    }

    return cursor;
}

// Using a pointer to video memory we can put characters to the display
// Every two addresses contain a character and a color
char putchar(char character)
{


    if (character == '\n') {
        cursorCol = 0;
        cursorRow++;
    } else {
        char * index = (char *)(VIDEO_MEM + ((cursorRow * 80 * 2) + (cursorCol * 2)));
        *index = character;
        index++;
        *index = TEXT_COLOR;
        cursorCol++;
        if (cursorCol > 79) {
            cursorCol = 0;
            cursorRow ++;
        }
    }

    setcursor(cursorCol, cursorRow);

	return character;
}

// Print the character array (string) using putchar()
// Print until we find a NULL terminator (0)
int printf(char string[]) 
{
    int index = 0;
    while (string[index] != 0) {
        putchar(string[index]);
        index++;
    }

	return 0;
}

// Prints an integer to the display
// Useful for debugging
int printint(uint32 n) 
{
	int characterCount = 0;
	if (n >= 10)
	{
        characterCount = printint(n / 10);
    }
    putchar('0' + (n % 10));
	characterCount++;

	return characterCount;
}

// Clear the screen by placing a ' ' character in every character location
void clearscreen()
{
    cursorCol = 0;
    cursorRow = 0;    
    setcursor(cursorCol, cursorRow);   

    for (int i = 0; i < 25; i++) {
        for (int j = 0; j < 80; j++) {
            putchar(' ');
        }
    }

    setcursor(0, 0);
    
	return;
}

// Initializes the keyboard characters
// Each index in the array "keymap" is the scancode
// Each value in the array is the corresponding ASCII character
// To fill out the rest of the characters refer to this chart:
// https://wiki.osdev.org/PS/2_Keyboard#Scan_Code_Set_1
void initkeymap()
{
    keymap[0x1E] = 'a';
    keymap[0x30] = 'b';
    keymap[0x2E] = 'c';
    keymap[0x20] = 'd';
    keymap[0x12] = 'e';
    keymap[0x21] = 'f';
    keymap[0x22] = 'g';
    keymap[0x23] = 'h';
    keymap[0x17] = 'i';
    keymap[0x24] = 'j';
    keymap[0x25] = 'k';
    keymap[0x26] = 'l';
    keymap[0x32] = 'm';
    keymap[0x31] = 'n';
    keymap[0x18] = 'o';
    keymap[0x19] = 'p';
    keymap[0x10] = 'q';
    keymap[0x13] = 'r';
    keymap[0x1F] = 's';
    keymap[0x14] = 't';
    keymap[0x16] = 'u';
    keymap[0x2F] = 'v';
    keymap[0x11] = 'w';
    keymap[0x2D] = 'x';
    keymap[0x15] = 'y';
    keymap[0x2C] = 'z';

    keymap[0x0B] = '0';  
    keymap[0x02] = '1';
    keymap[0x03] = '2';    
    keymap[0x04] = '3';    
    keymap[0x05] = '4';    
    keymap[0x06] = '5';    
    keymap[0x07] = '6';    
    keymap[0x08] = '7';    
    keymap[0x09] = '8';    
    keymap[0x0A] = '9';     
    
    keymap[0x39] = ' ';
    keymap[0x1C] = '\n';         

	return;
}

// retrieves scancode from keybaord
// once scancode is retrieved, it must be converted to ASCII using keyboard mapping
char getchar()
{
    char isKeyPressed = 0;
    char character = 0;
    while (!isKeyPressed) {
        char isKeyboardReady = 0;

        while (!isKeyboardReady) {
            uint8 status = inb(0x64);
            status &= 0x01;
            isKeyboardReady = status == 1;
        }

        uint8 scancode = inb(0x60);

        isKeyPressed = (scancode & 0x80) == 0 && scancode < 128;

        if (!isKeyPressed) {
            continue;
        }

        character = keymap[scancode];
    }

    return character;
} 

void scanf(char string[]) 
{
    int index = 0; 
    char character = 0;

    while (character != '\n') {
        character = getchar();
        if (character == '\n') {
            string[index] = '\0';
            break;
        } else {
            string[index] = character;       
            putchar(character);
        }
        
        index++;
    }

    return;
}