.ORIG x5000
 
; REMEMBER: Stuff in parentheses are explanations, not steps! Please do not take them verbatim! 
 
; --------------------------------------
 
; REGISTER CONTENTS (MEMDUMP to just before WORD_OUT)
 
; R0 will receive the beginning of the range of memory to dump. It will also act as the register to pass everything into various printing functions, such as PUTS, OUT, and WORD_OUT
; R1 will receive the ending address of memory to dump
; R2 is UNUSED
; R3 holds the two's complement of the address we are operating on
; R4 holds the address we are currently dumping
; R5 holds the ending address so that we know when to stop dumping memory
; R6 is our stack pointer
; R7 is UNUSED
 
; --------------------------------------
 
; MEMDUMP loops through addresses and prints out both the address and the value at that address in the range specified in R0 and R1. 
MEMDUMP
    ; Store R6 to the address held at OUT_STACK_R6 (STORE R6 into x5FF9 on the stack) (HINT: Do we use ST or STI for this? Why?)
    ; ; Load OUT_STACK_BASE into R6 (LOAD Stack starting address (x5FFF) into R6)
    ; Store the contents of R0 to the memory location CURRENTLY held by R6 (STORE R0 into stack area for registers) (in memory: x5FFF)
    ; Store the contents of R1 to the stack using an offset 1 word behind the stack pointer in memory (STORE R1 into stack area for registers) (in memory: x5FFE)
    ; Store the contents of R2 to the stack using an offset 2 words behind the stack pointer in memory (STORE R2 into stack area for registers) (in memory: x5FFD)
    ; Store the contents of R3 to the stack using an offset 3 words behind the stack pointer in memory (STORE R3 into stack area for registers) (in memory: x5FFC)
    ; Store the contents of R4 to the stack using an offset 4 words behind the stack pointer in memory  (STORE R4 into stack area for registers) (in memory: x5FFB)
    ; Store the contents of R5 to the stack using an offset 5 words behind the stack pointer in memory (STORE R5 into stack area for registers) (in memory: x5FFA)
    ; (NOTE: R6 is already stored in stack at (x5FF9))
    ; Store the contents of R7 to the stack using an offset 7 words behind the stack pointer in memory  (STORE R7 into stack area for registers) (in memory: x5FF8)
    ; Decrement R6 by #-8 (Moves Stack Pointer back so we can call other functions later (like WORD_OUT, or OUT or others))
 
    ; --------------------------------------
 
    ; EXTRA CREDIT SUGGESTION: If you wish to implement the extra credit portion, 
    ; here might be a good place to put the code, before we do anything else in
    ; this function. 
 
    ; If you choose to implement the extra credit, please place the comment "; EC3" at the top of your code. 
 
    ; --------------------------------------
 
    ; Copy R0 to R4
    ; Copy R1 to R5
 
    ; (Print line:  "Memory contents " ADDRESS " to " ADDRESS ":" NEWLINE)
    ; Load address of variable MEMCONBEGIN to R0 (HINT: What type of load do we use for printing strings?)
    ; Call PUTS TRAP function
 
    ; Copy R4 to R0
    ; Jump subroutine to WORD_OUT
 
    ; Load address of variable MEMCONMIDDLE to R0
    ; Call PUTS TRAP function
 
    ; Copy R5 to R0
    ; Jump subroutine to WORD_OUT
 
    ; Load address of variable MEMCONEND to R0
    ; Call PUTS TRAP function
 
    ; Load CHAR_LB variable to R0
    ; Call OUT TRAP function to print it
 
; Prints out each address and the value at that address in the range given by R4 and R5
MDLOOP
    ; C equivalent of the below: if((R5 - R4) < 0) goto MDMP_EXIT
    ; Copy R4 to R3
    ; Do the 2's complement of R3 (two steps)
    ; Add R5 and R3 and store in R3
    ; Branch only if negative to MDMP_EXIT
 
    ; C equivalent of the below: else: Print the Address
    ; Copy R4 to R0
    ; Jump subroutine to WORD_OUT
 
    ; Load variable CHAR_SPACE into R0
    ; Print it 3 times (using OUT)
 
    ; The below prints the value *at* the address
    ; Load the contents of the address held by R4 into R0 (HINT: we use an offset here) (in memory: at user defined address)
    ; Jump subroutine to WORD_OUT
 
    ; Load variable CHAR_LB to R0
    ; Print it using OUT TRAP function
 
    ; Increment the address in R4 by #1
    ; Branch unconditionally back to MDLOOP (loop beginning)
 
; Undoes the stack to how it was before this TRAP was called
MDMP_EXIT
    ; Increment the stack pointer by #8 (Undo stack address movement from beginning of function)
    ; Load the contents at the current memory location of R6 into R0 (LOAD R0 from stack area for registers.) (in memory: x5FFF)
    ; Load the contents at the memory location 1 word behind R6's current address into R1 (LOAD R1 from stack area for registers) (in memory: x5FFE)
    ; Load the contents at the memory location 2 words behind R6's current address into R2 (LOAD R2 from stack area for registers) (in memory: x5FFD)
    ; Load the contents at the memory location 3 words behind R6's current address into R3 (in memory: x5FFC)
    ; Load the contents at the memory location 4 words behind R6's current address into R4 (LOAD R4 from stack area for registers) (in memory: x5FFB)
    ; Load the contents at the memory location 5 words behind R6's current address into R5 (LOAD R5 from stack area for registers) (in memory: x5FFA)
    ; Load the contents at the memory location 7 words behind R6's current address into R7 (LOAD R7 from stack area for registers) (in memory: x5FF8)
    ; Load the contents at the memory location 6 words behind R6's current address into R6 (LOAD R6 from stack area for registers) (in memory: x5FF9)
    RET ; (If your IDE complains: Use JMP R7 for the same effect)
 
; --------------------------------------
 
; REGISTER CONTENTS (WORD_OUT and below)
 
; R0 will receive the word to ASCII-fy and then will hold the nibble that we will be printing out each loop iteration
; R1 is a masking/ASCII-fying helper register. It holds what bits we want to look at, and holds a value that helps us convert a hex digit to an ASCII digit. 
; R2 is a math/scratch register
; R3 is a counter register, specifically for the circular left shift
; R4 is unused
; R5 holds the address of the amount of times to shift (which is used similarly to a counter)
; R6 is our stack pointer
; R7 is unused
 
; --------------------------------------
 
; WORD_OUT will take a 16 bit word and print it out as ASCII characters. 
WORD_OUT
    ; First of all, we must save the registers onto the stack...
    ; Store the contents of R0 to the memory location CURRENTLY held by R6 (NOTE: this is a store with offset, since we are storing register to register with an offset of #0!) (in memory: x5FF7)
    ; Store the contents of R1 to the stack using an offset 1 word behind the stack pointer in memory (in memory: x5FF6)
    ; Store the contents of R2 to the stack using an offset 2 words behind the stack pointer in memory (in memory: x5FF5)
    ; Store the contents of R3 to the stack using an offset 3 words behind the stack pointer in memory (in memory: x5FF4)
    ; Store the contents of R4 to the stack using an offset 4 words behind the stack pointer in memory (in memory: x5FF3)
    ; Store the contents of R5 to the stack using an offset 5 words behind the stack pointer in memory (in memory: x5FF2)
    ; Store the contents of R6 to the stack using an offset 6 words behind the stack pointer's current location in memory (in memory: x5FF1)
    ; Store the contents of R7 to the stack using an offset 7 words behind the stack pointer in memory (in memory: x5FF0)
    ; Decrement R6 by #-8 (Increments the stack pointer by 8 words)
 
    ; Load CHAR_X into R0 (check for an 'x')
    ; Print it using OUT
 
    ; Load the EFFECTIVE address of NIBBLE_1_SHIFT into R5 (load the address of first amount of times to shift into R5)
 
; This label goes through each label from most significant to least, ASCII-fy it, then print it out. 
WO_NIBBLE_LOOP
    ; Load the MSB_MASK variable into R1
    ; Load the contents of the memory location 8 words IN FRONT OF the current address held in R6 to R0 (loads the word to print)
    ; Load the contents of the address held by R5 into R3 (HINT: use LDR. What's the offset for LDR? Remember, R5 currently holds the address of NIBBLE_1_SHIFT)
    ; Branch only if zero to WO_NIB_SHIFT_DONE
 
; --------------------------------------
 
; CIRCULAR LEFT SHIFTING: Like right shifting but easier
; Right shift of 12 == Circular Left of 4 ()
; R0 = Thing to shift
; R1 = Carry bit
; R2 = MSB Mask
; R3 = Counter
 
; --------------------------------------
 
; This function sets up the circular left shift. This part calculates whether we need to continue shifting, as well as checking if we need to set a carry bit. 
WO_CLS_LOOP
    ; AND the contents of R0 and R1; place them into R2 (checks whether or not we need to add a 1)
    ; Branch only if zero to WO_CLS
    ; Clear R2
    ; Increment R2 by #1
 
; Performs the circular left shift. 
WO_CLS
    ; Shift left once (below)
    ; Add R0 to itself (Perform a left shift by one place value)
    ; Add R0 and R2, store into R0 (Add the carry bit from R2)
    ; Decrement R3 by #-1
    ; Branch only if positive to WO_CLS_LOOP
 
; We are done shifting and now we need to determine if the character is alphabetical or numeric. 
WO_NIB_SHIFT_DONE
    ; Load the NUM_MASK variable into R1
    ; And the contents of R1 and R0 together and place them back into R0
 
    ; Load 0xA (aka: CHAR_NL) into R1 (NOTE: if you are on a UNIX system: do NOT change this value. We WANT x0A here)
    ; 2's complement R1
    ; Do a comparison of R0 and R1 and store the result in R1
    ; Branch only when negative to WO_CHAR_NUM (this means we have a number to ASCIIfy)
 
    ; Copy the value in R1 to R0
    ; Load the ALPHA_BASE variable into R1 (loads in ASCII 'A')
    ; Do a comparison of R0 and R1; store the result in R0(gets our ASCII character version of the nibble 'A' - 'F')
    ; Branch unconditionally to WO_CHAR_PRINT
 
; ASCII-fy a number
WO_CHAR_NUM
    ; Load variable DIGIT_BASE into R1 (loads in ASCII '0')
    ; Do a comparison of R0 and R1; store the result in R0 (gets our ASCII character version of the nibble '0' - '9')
 
; This label handles printing out the character and setting up for the next iteration of the loop
WO_CHAR_PRINT
    ;  Call OUT TRAP function (Print the ASCII version of the nibble)
    ; Load the contents of the address currently held by R5 into R3 (Reloads the word we are ASCII-fying)
    ; Branch if equal to WO_EXIT (Remember: R5 holds the address of the array NIBBLE_1_SHIFT. Since arrays are multi-word objects, with each entry occupying one memory address, we start at the beginning of the array and move rightward. Since the last value in the array is a zero, we are effectively using the array as a sort of counter. This is so we free up a register later, as well as using the values as a "shift counter".)
    ; Increment R5 by #1
    ; Branch unconditionally back to WO_NIBBLE_LOOP
 
; Sets the stack back up to the way it was before
WO_EXIT
    ; Increment the stack pointer by #8 (re-increments the stack pointer to where it was originally)
    ; Load the contents at the current memory location of R6 into R0 (in memory: x5FF7)
    ; Load the contents at the memory location 1 word behind R6's current address into R1 (in memory: x5FF6)
    ; Load the contents at the memory location 2 words behind R6's current address into R2 (in memory: x5FF5)
    ; Load the contents at the memory location 3 words behind R6's current address into R3 (in memory: x5FF4)
    ; Load the contents at the memory location 4 words behind R6's current address into R4 (in memory: x5FF3)
    ; Load the contents at the memory location 5 words behind R6's current address into R5 (in memory: x5FF2)
    ; Load the contents at the memory location 6 words behind R6's current address into R6 (in memory: x5FF1)
    ; Load the contents at the memory location 7 words behind R6's current address into R7 (in memory: x5FF0)
 
    RET
 
; --------------------------------------
; GLOBAL VARIABLES
 
MEMCONBEGIN     .STRINGZ "Memory Contents " ; First bit of header line
MEMCONMIDDLE     .STRINGZ " to " ; Middle bit of header line
MEMCONEND       .STRINGZ ":" ; Ending bit of header line
CHAR_X          .FILL x0078 ; The value for lowercase 'x' in ASCII
CHAR_NL         .FILL x000A ; Newline character (Windows)
CHAR_LB         .FILL x000D ; Newline/line break character (Mac/Linux/Chrome OS)
CHAR_SPACE      .FILL x0020 ; The value for the space character in ASCII
 
OUT_STACK_BASE  .FILL x5FFF ; The base address of the stack
OUT_STACK_R6    .FILL x5FF9 ; The address in memory that the contents of R6 will go to
 
; Amounts to shift each nibble left circularly by (with x0000 as a sentinel to tell us to not shift and continue). Normally we'd need to right shift, but LC-3 makes this very difficult. So instead we shift left circularly. 
NIBBLE_1_SHIFT  .FILL #4
                .FILL #8
                .FILL #12
                .FILL x0000
 
MSB_MASK        .FILL x8000 ; A mask that looks for the most significant bit in the word being set. In other words, it is 1000 0000 0000 0000 in binary. 
 
NUM_MASK        .FILL x000F ; A mask that looks for the lowest nibble of the word being set. In other words, it is 0000 0000 0000 1111 in binary. 
 
ALPHA_BASE      .FILL x0041 ; The beginning of the uppercase ASCII letters
DIGIT_BASE      .FILL x0030 ; The beginning of the digits in ASCII
 
.END