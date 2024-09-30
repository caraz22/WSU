#include "./io.h"

int main() 
{
	initkeymap();
	
	// Clear the screen
	clearscreen();

	// Print "Hello World!"
	printf("Hello World!");

	char input[100];

	while(1) {
		printf("\nPlease type something: ");
		scanf(input);
		printf("\nYou typed: ");
		printf(input);
	}
	
	return 0;
}