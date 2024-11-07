#include "./io.h"
#include "./multitasking.h"
#include "./irq.h"
#include "./isr.h"

void prockernel();
void proca();

int main() 
{
	// Clear the screen
	clearscreen();

	// Initialize our keyboard
	initkeymap();

	startkernel(prockernel);
	
	return 0;
}

// The user processes

void proca()
{
	printf("A");
	exit();
}

void procb() 
{
	printf("B");
	yield();
	yield();
	exit();
}

void procc() 
{
	printf("C");
	yield();
	yield();
	yield();
	yield();
	exit();
}

void procd() 
{
	printf("D");
	yield();
	yield();
	yield();
	exit();
}

void proce() 
{
	printf("E");
	yield();
	yield();
	exit();
}

void prockernel()
{
	printf("Kernel Process Starting...\n");
	
	// Create the user processes

	createproc(proca, (void *) 0x3000);
	createproc(procb, (void *) 0x3100);
	createproc(procc, (void *) 0x3200);
	createproc(procd, (void *) 0x3300);
	createproc(proce, (void *) 0x3400);

	// Schedule the next process

	int userprocs = schedule();

	while(userprocs > 0)
	{	
		yield();
		userprocs = schedule();

	}

	printf("Kernel Process Exiting...\n");
}

