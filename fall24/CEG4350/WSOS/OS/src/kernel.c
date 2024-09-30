#include "./io.h"

int main() 
{
	initkeymap();
	

	// Clear the screen
	clearscreen();

	// Print "Hello World!"
	printf("Hello World!\n");

	while(1) {
		printf("Please type something: ");
		scanf();
	}
	
	return 0;
}