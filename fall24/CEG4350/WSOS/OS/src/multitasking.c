#include "./types.h"
#include "./multitasking.h"
#include "./io.h"

// An array to hold all of the processes we create
proc_t processes[MAX_PROCS];

// Keep track of the next index to place a newly created process in the process array
uint8 process_index = 0;

proc_t *prev;       // The previously ran user process
proc_t *running;    // The currently running process, can be either kernel or user process
proc_t *next;       // The next process to run
proc_t *kernel;     // The kernel process

// Select the next user process (proc_t *next) to run
// Selection must be made from the processes array (proc_t processes[])
int schedule()
{
    process_index = 1;
    for (int i = process_index; i < MAX_PROCS + 1; i++)
    {
        // if ()
    }
    // if user process is ready
    if (processes[1].status == PROC_READY && processes[1].type == PROC_USER) {
        // select user process to run next
        next = &processes[1];
        return 1;
    }

    return 0;
}

// Create a new user process
// When the process is eventually ran, start executing from the function provided (void *func)
// Initialize the stack top and base at location (void *stack)
// If we have hit the limit for maximum processes, return -1
// Store the newly created process inside the processes array (proc_t processes[])
int createproc(void *func, char *stack)
{
    // If we have filled our process array, return -1

    if(process_index >= MAX_PROCS)
    {
        return -1;
    }

    // Create the new user process

    proc_t userproc;
    userproc.status = PROC_READY; // Processes start ready to run
    userproc.type = PROC_USER;    // Process is a kernel process
    userproc.eip = func;
    userproc.esp = stack;
    userproc.ebp = stack;

    // Assign a process ID and add process to process array

    userproc.pid = process_index;
    processes[process_index] = userproc;
    process_index++;

    return 0;
}

// Create a new kernel process
// The kernel process is ran immediately, executing from the function provided (void *func)
// Stack does not to be initialized because it was already initialized when main() was called
// If we have hit the limit for maximum processes, return -1
// Store the newly created process inside the processes array (proc_t processes[])
int startkernel(void func())
{
    // If we have filled our process array, return -1

    if(process_index >= MAX_PROCS)
    {
        return -1;
    }

    // Create the new kernel process

    proc_t kernproc;
    kernproc.status = PROC_RUNNING; // Processes start ready to run
    kernproc.type = PROC_KERNEL;    // Process is a kernel process

    // Assign a process ID and add process to process array

    kernproc.pid = process_index;
    processes[process_index] = kernproc;
    kernel = &processes[process_index];     // Use a proc_t pointer to keep track of the kernel process so we don't have to loop through the entire process array to find it
    process_index++;

    // Assign the kernel to the running process and execute

    running = kernel;
    func();

    return 0;
}

// Terminate the process that is currently running (proc_t current)
// Assign the kernel as the next process to run
// Context switch to the kernel process
void exit()
{
    running->status == PROC_TERMINATED;      
    if (running->type == PROC_USER) {
        next = kernel;
        switchcontext();
    }

    return;
}

// Yield the current process
// This will give another process a chance to run
// If we yielded a user process, context switch to the kernel process
// If we yielded a kernel process, context switch to the next process
// The next process should have already been selected via scheduling
void yield()
{
    // if we are currently running a user process
    if (running->type == PROC_USER) {
        running->status == PROC_READY;
        // select the kernel to run next
        next = kernel;
    } else if (!schedule()) {
        if (next == 0) {
            clearscreen(); 
            printf("Error: next process is invalid\n");
            while (1) {
            }
        }
    }

    // context switch to the process "next"
    switchcontext();

    return;
}

// Context switching function
// This function will save the context of the running process (proc_t running)
// and switch to the context of the next process we want to run (proc_t next)
// The running and next processes must both be valid for this function to work
// if they are not, our OS will certainly crash
void __attribute__((naked)) switchcontext()
{
    // Capture all the register values so we can reload them if we ever run this process again
    register uint32 eax asm ("eax");    // General purpose registers
    register uint32 ebx asm ("ebx");
    register uint32 ecx asm ("ecx");
    register uint32 edx asm ("edx");
    register uint32 esi asm ("esi");    // Indexing registers
    register uint32 edi asm ("edi");
    register void *ebp asm ("ebp");     // Stack base pointer
    register void *esp asm ("esp");     // Stack top pointer
    
    asm volatile("pushfl");
    asm volatile("pop %eax");
    register uint32 eflags asm ("eax"); // Flags and conditions

    asm volatile("mov %cr3, %eax");
    register uint32 cr3  asm ("eax");   // CR3 for virtual addressing

    // Store all the current register values inside the process that is running
    running->eax    = eax;
    running->ebx    = ebx;
    running->ecx    = ecx;
    running->edx    = edx;

    running->esi    = esi;
    running->edi    = edi;

    running->ebp    = ebp;
    running->esp    = esp;

    running->eflags = eflags;
    running->cr3    = cr3;

    // Set the next instruction for this process to be the resume after the context switch
    running->eip    = &&resume;

    // Start running the next process
    running = next;
    running->status = PROC_RUNNING;

    // Reload all the registers previously saved from the process we want to run
    asm volatile("mov %0, %%eax" : : "r"(running->eflags));
    asm volatile("push %eax");
    asm volatile("popfl");

    asm volatile("mov %0, %%eax" : :    "r"(running->eax));
    asm volatile("mov %0, %%ebx" : :    "r"(running->ebx));
    asm volatile("mov %0, %%ecx" : :    "r"(running->ecx));
    asm volatile("mov %0, %%edx" : :    "r"(running->edx));

    asm volatile("mov %0, %%esi" : :    "r"(running->esi));
    asm volatile("mov %0, %%edi" : :    "r"(running->edi));

    asm volatile("mov %0, %%ebp" : :    "r"(running->ebp));
    asm volatile("mov %0, %%esp" : :    "r"(running->esp));

    asm volatile("mov %0, %%cr3" : :    "r"(running->cr3));

    // Jump to the last instruction we saved from the running process
    // If this is a new process this will be the beginning of the process's function
    asm volatile("jmp *%0" : : "r" (running->eip));

    // This resume address will eventually get executed when the previous process gets executed again
    // This will allow us to resume the previous process after our yield
    resume:
    asm volatile("ret");
}