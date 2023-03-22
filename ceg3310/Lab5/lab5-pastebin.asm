Lab 5 TA Notes: 
 
; These notes are an explanation and comparison of the processes occurring in lab 5. They are NOT pseudocode! Do not follow them verbatim. Instead, try to understand what is occurring in each register and in memory and replicate it using assembly. 
 
; These notes will have both C and assembly! If you try to use them for your project, you will need to remove parts of them. 
 
; The below is the default code for the stack setup. Read the professor's comments carefully and try drawing the stack as you go using an excel sheet. Refer to the following image for the stack: https://ibb.co/80fqgN4
 
; ************************************************************************************************
 
; REGISTER FUNCTIONALITY
; R0 - one of the registers performing the math operations in square(). Additionally, it does other things in other functions such as holding the array pointer address or holding the running total. 
; R1 - one of the registers performing the math operations in square(). It has other uses in other functions such as holding int x or holding the running total in order to do math. 
; R2 - holds the array size, which is to be negated and used as a comparator for the amount of loops we must do. In square, it also serves as a counter. 
; R3 - the counter that is used alongside the comparator. 
; R4 - ALWAYS points to global variables. Please do not change this register's value after assigning it. 
; R5 - The frame pointer. Each function has its own, so it must be saved when new functions are called. 
; R6 - The stack pointer. There is one per CPU core. It stays constant between functions. 
; R7 - holds the return address and must be saved each time a new function is called. 
 
; ************************************************************************************************
 
.ORIG x3000
;	Your main() function starts here
LD R6, STACK_PTR			;	LOAD the pointer to the bottom of the stack in R6	(R6 = x5013)
ADD R6, R6, #-1				;	Allocate room for your return value 				(R6 = x5012)
ADD R5, R6, #0				;	MAKE your frame pointer R5 point to local variables	(R5 = x5012)
LEA R4, GLOBAL_VARS			;	MAKE your global var pointer R4 point to globals	(R4 = ADDRESS(GLOBAL_VARS))
 
LEA R0, ARRAY_POINTER		;	LOAD the address of your array pointer
STR R0, R5, #0				;	STORE pointer to array in stack						(R5 = x5012)
ADD R6, R6, #-2				;	MAKE stack pointer go back two addresses			(R6 = x5010)
 
STR R0, R6, #0				;	STORE pointer to array (input to sumOfSquares())		(R6 = x5010)
ADD R6, R6, #-1				;	MAKE stack pointer go back one address				(R6 = x500F)
 
LDR R0, R4, #0				;	LOAD MAX_ARRAY_SIZE value into R0
STR R0, R6, #0				;	STORE MAX_ARRAY_SIZE value into stack				(R6 = x500F)
 
ADD R6, R6, #-1				;	MAKE stack pointer go back one address				(R6 = x500E)
JSR sumOfSquares			;	CALL sumOfSquares() function
LDR R0, R5, #-4				;	LOAD return value of sumOfSquares() into R0			(R5 = x5012)
 
ADD R6, R6, #1				;	POP input to sumOfSquares() off the stack				(R6 = x5010)
 
STR R0, R5, #-1				;	STORE int total into stack							(R5 = x5012)
STR R0, R5, #1				;	STORE main() return value into stack				(R5 = x5012)
 
ADD R6, R6, #4				;	POP stack											(R6 = x5014)
HALT
 
; ************************************************************************************************
 
GLOBAL_VARS					;	Your global variables start here
MAX_ARRAY_SIZE	.FILL x0005	;	MAX_ARRAY_SIZE is a global variable and predefined
ARRAY_POINTER	.FILL x0002	;	ARRAY_POINTER points to the top of your array (5 elements)
				.FILL x0003
				.FILL x0005
				.FILL x0000
				.FILL x0001
STACK_PTR		.FILL x5013	;	STACK_PTR is a pointer to the bottom of the stack	(x5013)
 
; ************************************************************************************************
 
sumOfSquares
;	Your sumOfSquares() function starts here
 
;	Allocate room for your return value relative to R6				(R6 = x500D)
 
;	STORE the return address in the stack (which register holds the return address?)				(R6 = x500D)
;	MAKE stack pointer go back one address (HINT: try using addition to move the stack pointer!)				(R6 = x500C)
 
;	STORE R5 (previous frame pointer) in stack			(R6 = x500C)
;	MAKE stack pointer go back one address				(R6 = x500B)
 
;	STORE R3 in stack									(R6 = x500B)
;	MAKE stack pointer go back one address				(R6 = x500A)
 
;	STORE R2 in stack									(R6 = x500A)
;	MAKE stack pointer go back one address				(R6 = x5009)
 
;	STORE R1 in stack									(R6 = x5009)
;	MAKE stack pointer go back one address				(R6 = x5008)
 
;	STORE R0 in stack									(R6 = x5008)
;	MAKE stack pointer go back one address				(R6 = x5007)
 
;	MAKE frame pointer point to local variables				(R5 = x5007)
;	MAKE stack pointer point to top of stack (HINT: the TOP of the stack, not the BOTTOM that is given in the variable STACK_PTR)			(R6 = x5005)
 
;	LOAD input from main() (arraySize) into R2 (HINT: Where is arraySize located relative to the frame pointer? Use that as the offset!)		(R5 = x5007)
;	CLEAR R3 to use as counter (HINT: How did we do this in previous labs?)
;	STORE counter = 0 value into stack (HINT: Which register functions as the counter?)					(R5 = x5007)
;	STORE sum = 0 value into stack (HINT: We can store sum 1 word behind the counter) 						(R5 = x5007)
 
;	NEGATE R2 for BRANCH checking (HINT: This is a 2's complement! It's two commands; negate and add 1)
 
; We did a while loop as part of lab 2-3! Refer to the instructions here to recreate it: https://pastebin.com/rhhpADja (Remember to MODIFY the loop for this lab!)
WHILE_LOOP					;	START of while loop
;	CHECK if we should stop looping, i.e. counter > arraySize (HINT: what happens if counter is greater than or equal to arraySize? Remember that we did the 2's complement of arraySize previously! Also, which register holds our output? It's not R2 or R3.) 
; Branch to DONE if these conditions are met
 
;	LOAD array pointer into R0	(HINT: This refers to *a! Where is *a located on in the sumOfSquares() stack image relative to R5?)					(R5 = x5007)
;	ADD counter + array address into R0 to get value at index (HINT: where are the array address and counter both stored?)
;	LOAD value at the current array address into R0 (HINT: your offset will be zero!)
;	STORE value from array in stack (int x)	(HINT: Refer to the second column of the graphic of the stack to place int x relative to R5)			(R5 = x5007)
 
;	MAKE stack pointer go back one address				(R6 = x5004)
;	CALL square() function (REMEMBER: We WILL want to return here!)
;	LOAD return value of square() into R0	(HINT: refer to the second and third columns of the graphic of the stack for the offset value)			(R5 = x5007)
;	LOAD current running sum into R1	(HINT: Where is the sum stored relative to R5's current location?)				(R5 = x5007)
;	ADD current running sum to return value of squares() (HINT: Use R0 and R1 for this)
;	STORE new sum into stack	(HINT: replace the old one)						(R5 = x5007)
;	ADD 1 to counter
;	STORE counter into stack							(R5 = x5007)
;   Branch unconditionally back to WHILE_LOOP
 
;   DONE serves to put the stack back to the way it was in the first column of the stack graphic. 
DONE
;	LOAD int sum into R0								(R5 = x5007)
;	STORE int sum into return value on stack	(HINT: where is sum on the stack relative to the frame pointer's current location?)		(R5 = x5007)
 
;	MAKE stack pointer go to end of frame		(HINT: where is R6 relative to R5?)		(R6 = x5007)
 
;	MAKE stack pointer go forward one address			(R6 = x5008)
;	RESTORE R0 to value stored on stack		(HINT: Where is R0 relative to R6's current location? Refer to the graphic for the offset)			(R6 = x5008)
 
;	MAKE stack pointer go forward one address			(R6 = x5009)
;	RESTORE R1 to value stored on stack					(R6 = x5009)
 
;	MAKE stack pointer go forward one address			(R6 = x500A)
;	RESTORE R2 to value stored on stack					(R6 = x500A)
 
;	MAKE stack pointer go forward one address			(R6 = x500B)
;	RESTORE R3 to value stored on stack					(R6 = x500B)
 
;	MAKE stack pointer go forward one address			(R6 = x500C)
;	RESTORE R5 to value stored on stack					(R6 = x500C)
 
;	MAKE stack pointer go forward one address			(R6 = x500D)
;	RESTORE R7 to value stored on stack					(R6 = x500D)
 
;	POP stack	(HINT: Return the stack pointer to the top of main()'s stack)										(R6 = x500F)
 
RET
 
; ************************************************************************************************
 
; We will be doing the square function a bit differently than we did with Lab 2-1. However, both ways are valid ways to square numbers in LC-3. 
square
;	Your square() function starts here
;	Allocate 1 word for your return value 				(R6 = x5003)
 
;	STORE the return address in the stack	(HINT: Which register holds the return address?)			(R6 = x5003)
;	MAKE stack pointer go back one address				(R6 = x5002)
 
;	STORE R5 (sumOfSquares()'s stack pointer) in stack			(R6 = x5002)
;	MAKE stack pointer go back one address				(R6 = x5001)
 
;	STORE R3 in stack									(R6 = x5001)
;	MAKE stack pointer go back one address				(R6 = x5000)
 
;	STORE R2 in stack									(R6 = x5000)
;	MAKE stack pointer go back one address				(R6 = x4FFF)
 
;	STORE R1 in stack									(R6 = x4FFF)
;	MAKE stack pointer go back one address				(R6 = x4FFE)
 
;	STORE R0 in stack									(R6 = x4FFE)
;	MAKE stack pointer go back one address				(R6 = x4FFD)
 
;	MAKE frame pointer point to local vars		(HINT: the local variable in this case is the product variable. Refer to the third column of the stack graphic)	(R5 = x4FFD)
 
;	CLEAR R0 for calculations
;	STORE product = 0 into stack						(R5 = x4FFD)
 
;	LOAD int x into R1 for multiplication		(HINT: where is int x relative to the frame pointer's current location?)		(R5 = x4FFD)
 
;	COPY int x into R2 for multiplication
 
MULTIPLY_LOOP
;	ADD R1 + R0 to keep running total of multiplication
;	SUBTRACT 1 from R2 to keep track of loop
; Keep branching back to MULTIPLY loop as long as we are greater than zero
 
;	STORE multiplication into int product on stack	(HINT: Which register holds the multiplication? It's the same one used at the top of MULTIPLY_LOOP)	(R5 = x4FFD)
;	STORE multiplication into return value on stack		(HINT: Where is the return value for square() located relative to the frame pointer?) (R5 = x4FFD)
 
; CLEAN UP STEPS: These steps restore the stack back to the way it was when sumOfSquares() executed. 
;	MAKE stack pointer go forward one address			(R6 = x4FFE)
;	RESTORE R0 to value stored on stack					(R6 = x4FFE)
 
;	MAKE stack pointer go forward one address			(R6 = x4FFF)
;	RESTORE R1 to value stored on stack					(R6 = x4FFF)
 
;	MAKE stack pointer go forward one address			(R6 = x5000)
;	RESTORE R2 to value stored on stack					(R6 = x5000)
 
;	MAKE stack pointer go forward one address			(R6 = x5001)
;	RESTORE R3 to value stored on stack					(R6 = x5001)
 
;	MAKE stack pointer go forward one address			(R6 = x5002)
;	RESTORE R5 to value stored on stack					(R6 = x5002)
 
;	MAKE stack pointer go forward one address			(R6 = x5003)
;	RESTORE R7 to value stored on stack					(R6 = x5003)
 
;	POP stack		(HINT: Pop the rest of the stack off. Where is the top of sumOfSquares()'s stack relative to the stack pointer?)									(R6 = x5005)
 
RET
 
.END
 
; ************************************************************************************************
 
// C code included below
#include <stdio.h> // You do not have to implement stdio.h in assembly. Please don't!!!
#define MAX_ARRAY_SIZE 5 // equivalent to global variable MAX_ARRAY_SIZE in assembly
 
int sumOfSquares(int a[], int arraySize);
int square(int x);
 
int ar[MAX_ARRAY_SIZE] = {2, 3, 5, 0, 1}; // sumOfSquares = 39
 
int main()
{
    int *array = ar;   
    int total;
 
    // Calculate the sum of all squares in an array, i.e. 2^2 + 3^2 + 5^2 + 0^2 + 1^2 = 4 + 9 + 25 + 0 + 1 = 39
 
    total = sumOfSquares(array, MAX_ARRAY_SIZE);
 
    printf("Total: %d", total); // You do not have to implement a printf in assembly
 
    return total;
}
 
// Function:    sumOfSquares
//
// Inputs:      array pointer (a)
//              size of array (arraySize)
//
// Outputs:     sum of all squared elements in array (sum)
 
int sumOfSquares(int a[], int arraySize)
{
    int counter = 0; // counter is used to keep track of how many times we loop
    int sum = 0;
 
    while(counter < arraySize)
    {
        //call the square function until counter > arraySize, add the result to the current sum
        sum = square(a[counter]) + sum;
        counter = counter + 1;
    }
 
    return sum;
}
 
// Function:    square
//
// Inputs:      number to square (x)
//
// Outputs:     the squared number (product)
 
int square(int x)
{
    int product = 0;
 
    product = x * x;
 
    return product;
}