.ORIG x3000
 
; ****************************************************************
 
; BEGINNING REGISTER GUIDE
; R0 is an input/output register. 
; R1 is a scratch math register.
; R2 holds the return value from FIBONACCI, which doubles as the return value for BEGINNING.
; R3 is a scratch math register. 
; R4 is the global variable pointer. DO NOT MODIFY IT ONCE IT IS SET. 
; R5 is the frame pointer. The frame pointer points to the BOTTOM of the local variables in the current frame/function. Each function has its own frame pointer, so you MUST preserve it when changing functions!
; R6 is your stack pointer. It ALWAYS points to the top of the stack. There is one stack pointer per CPU (one total for this program). To push an item to the stack, allocate space for it and then store it to that space. To pop an item off the stack, move the stack pointer past that item. It will still persist in memory, but will no longer be a member of the stack. 
; R7 is the return address. It must be preserved between functions. 
 
; ****************************************************************
BEGINNING
;	Your main() function starts here
;	LOAD the pointer to the bottom of the stack in R6 (HINT: Use STACK_PTR for this!)	(R6 = x5013)
;	Allocate room for your return value 	(HINT: Move the stack pointer back to allocate space.)			(R6 = x5012)
;	MAKE your frame pointer R5 point to local variables	(HINT: We are setting up the frame pointer for BEGINNING. Which register do we initialize R5 relative to?) (R5 = x5012)
;	MAKE your global var pointer R4 point to globals	(R4 = ADDRESS(GLOBAL_VARS))
;	LOAD the start of the string into R0 (HINT: We can use PROMPT0 for this! And, which load do we use for printing text: LD, LDI, LDR, or LEA? Think about it!)
;	PRINT the prompt (HINT: It's a Trap! But which one? Note the difference between prompt and output!)
;	GET the character the user entered (HINT: It's a Trap! But which one?)
;	PRINT the character the user entered (HINT: It's a Trap! But which one?)
;	LOAD the value to subtract from an ASCII number to convert to decimal (HINT: Use R1 to hold the value since R0 is already in use. We can use ASCII_NUM to initialize it.)
;	CONVERT ASCII numeric character to decimal (HINT: Which register is the ASCII character held in? Which register is the conversion value held in? And which register of those two should we place our result in?)
;	COPY R0 into R1 for later use (HINT: How did we copy in previous labs? There's no MOV command.)
;	STORE the decimal input to fibonacci on the stack	(HINT: The value stored will be located in the destination register from the previous step.) (R6 = x5012)
;	MAKE stack pointer go back one address				(R6 = x5011)
;	CALL FIBONACCI (HINT: FIBONACCI is NOT a trap but a user function. How do we call user functions?)
;	LOAD return value of FIBONACCI into R2	(HINT: We start here after we return from FIBONACCI. Which register do we want to use to load the return value into R2? R5 or R6?)			(R5 = x5012)
;	POP input to FIBONACCI off the stack (HINT: Remember that the stack pointer is ALWAYS the top of the stack. If SP goes below a value, that value is no longer part of the stack (although it still remains in memory). Knowing this, how do we pop input off of the stack?) 				(R6 = x5012)
;	Load the prompt into the output register (HINT: Load PROMPT1 into your output register. Which output register did we use for printing PROMPT0?)
;	Print the prompt (HINT: It's a Trap! But which one?)
;	Copy the value in R1 to R0
;	LOAD the value to subtract from an ASCII number to convert to decimal (HINT: Use R1 to hold the value since R0 is already in use. We can use ASCII_NUM to initialize it.)
;	Do a two's complement (HINT: Do a two's complement for this step. Please note that a two's complement is two commands: A negate and an add #1!)
;	Second step of two's complement
;	CONVERT ASCII numeric character to decimal (HINT: Which register is the ASCII character held in? Which register is the conversion value held in? And which register of those two should we place our result in?)
;	Print out output (HINT: It's a Trap! But which one?)
;	Load the prompt into the output register (HINT: Load PROMPT2 into your output register. Which output register did we use for printing PROMPT0?)
;	Print the prompt (HINT: It's a Trap! But which one?)
;	COPY R2 to R3
;	CLEAR R1
 
; Checks the amount of tens in your ASCII digit (REMEMBER: You will be getting out two characters. For example, if we enter a one, we'd get out x31. To convert to decimal, we subtract ASCII zero and then, if there's a tens place value, strip it down to a digit so we can print it.)
CHECK_10S
;	INCREMENT R1 to start counting the number of 10s
;	SUBTRACT 10 from R3
;	BRANCH to CHECK_10s if R3 is non negative
;	SUBTRACT 1 from R1
;	BRANCH to SKIP_PRINT10s if there are no 10s  (HINT: If there are no tens, then what is the branch condition?)
;	COPY R1 to R0 for conversion
;	LOAD the value to subtract from an ASCII number to convert to decimal (HINT: Use R1 to hold the value since R0 is already in use. We can use ASCII_NUM to initialize it.)
;	Do a two's complement (HINT: Do a two's complement for this step. Please note that a two's complement is two commands: A negate and an add #1!)
;	Second step of two's complement
;	ADD R0 and R1 to add the amount of tens places to get the tens place digit
;	PRINT the character (HINT: It's a Trap! But which one?)
 
; If there's no tens place value
SKIP_PRINT10S
;	ADD #10 to R3 (HINT: This is a failsafe to keep the value from going negative.)
;	CLEAR R1
 
;	Checks the ones place value
CHECK_1S
;	ADD #1 to R1 (HINT: This indicates we have at least a 1 value.)
;	DECREMENT R3 (HINT: R3 is your counter.)
;	BRANCH back to CHECK_1s if R3 is non negative
;	DECREMENT R1 and store in R0 (HINT: This is because the CHECK_1s will overshoot by one.)
;	LOAD the value to subtract from an ASCII number to convert to decimal (HINT: Use R1 to hold the value since R0 is already in use. We can use ASCII_NUM to initialize it.)
;	Do a two's complement (HINT: Do a two's complement for this step. Please note that a two's complement is two commands: A negate and an add #1!)
;	Second step of two's complement
;	CONVERT ASCII numeric character to decimal (HINT: Which register is the ASCII character held in? Which register is the conversion value held in? And which register of those two should we place our result in?)
;	PRINT a character (HINT: It's a Trap! But which one?)
;	PRINT out the prompt (HINT: Use PROMPT3 for this, as well as the same load command and register you used in previous steps.)
;	Print the string of characters (HINT: It's a Trap! But which one?)
;	STORE main() return value into stack (HINT: Use R2 for this!)				(R5 = x5012)
;	POP stack (HINT: Draw a picture of the stack. How many variables do we have to pop off the stack in order to return R6 to its starting location?)											(R6 = x5014)
;	BRANCH unconditionally back to BEGINNING
;	HALT the program (HINT: It's a Trap! But which one?)
 
GLOBAL_VARS					;	Your global variables start here
PROMPT0 		.STRINGz	"Please enter a number n: ";	The first prompt to print
STACK_PTR		.FILL x5013	;	STACK_PTR is a pointer to the bottom of the stack	(x5013)
ASCII_NUM		.FILL #-48	;
PROMPT1 		.STRINGz	"\nF(";	The second prompt
PROMPT2 		.STRINGz	") = ";	The second prompt
PROMPT3			.STRINGz	"\n"
 
; ****************************************************************
 
; FIBONACCI REGISTER GUIDE
; R0, R1, and R2 are all multipurpose math registers. Can you figure out exactly what each one is doing?
; R3 is unused.
; R4 is the global variable pointer. DO NOT MODIFY IT ONCE IT IS SET. 
; R5 is the frame pointer. The frame pointer points to the BOTTOM of the local variables in the current frame/function. Each function has its own frame pointer, so you MUST preserve it when changing functions!
; R6 is your stack pointer. It ALWAYS points to the top of the stack. There is one stack pointer per CPU (one total for this program). To push an item to the stack, allocate space for it and then store it to that space. To pop an item off the stack, move the stack pointer past that item. It will still persist in memory, but will no longer be a member of the stack. 
; R7 is the return address. It must be preserved between functions. 
 
; ****************************************************************
 
FIBONACCI
;	Your fibonacci subroutine starts here
;	Allocate room for your return value 				(R6 = x5010)
 
;	STORE the return address in the stack	(HINT: What register is the return address held in? Do we do this operation relative to the stack pointer or the frame pointer?)			(R6 = x5010)
;	MAKE stack pointer go back one address				(R6 = x500F)
 
;	STORE R5 (previous frame pointer) in stack	(HINT: We are currently storing the frame pointer for BEGINNING in the stack so that when we RET back to it, the frame pointer is preserved. Once this store is done, we can modify R5 again.)		(R6 = x500F)
;	MAKE stack pointer go back one address				(R6 = x500E)
 
;	STORE R3 in stack									(R6 = x500E)
;	MAKE stack pointer go back one address				(R6 = x500D)
 
;	STORE R2 in stack									(R6 = x500D)
;	MAKE stack pointer go back one address				(R6 = x500C)
 
;	STORE R1 in stack									(R6 = x500C)
;	MAKE stack pointer go back one address				(R6 = x500B)
 
;	STORE R0 in stack									(R6 = x500B)
;	MAKE stack pointer go back one address				(R6 = x500A)
 
;	MAKE R5 point to R6		(HINT: Now your stack pointer will point at the bottom of FIBONACCI's local variables. What is the offset relative to R6?)							(R5 = x500A)
 
;;;;;;
 
;	LOAD input from stack	(HINT: Which register will input go in? Where is the input located on the stack relative to the frame pointer?)							(R5 = x500A)
;	CHECK if input = 1	(HINT: We can use R1 as a compare register. What value should it hold?)
;	BRANCH if zero to END_ALL_CASES
;	ADD 1 to R0
;	CHECK if input = 0	(HINT: What value is in the input register right now? What do whe have to do to make it zero?)
;	BRANCH if zero to END_ALL_CASES
 
;	CALCULATE n-1	(HINT: First general case. What value is in the input register right now? How do we make it equal to (n-1)?)
;	STORE input to fibonacci(n-1) on stack		(HINT: We are storing ON THE STACK. Which register holds input? Where is the stack pointer right now?)		(R6 = x500A)
;	MAKE stack pointer go back one address				(R6 = x5009)
;	JUMP subroutine to FIBONACCI
;	LOAD return value into R1							(R5 = x500A)
;	POP input to F(n-1)									(R6 = x500A)
 
;	CALCULATE n-1-1 (n-2)	(HINT: second general case. What value is in the input register right now? How do we make it equal to (n-2)?)
;	STORE input to fibonacci(n-2) on stack		(HINT: We are storing ON THE STACK. Which register holds input? Where is the stack pointer right now?)		(R6 = x500A)
;	MAKE stack pointer go back one address				(R6 = x5009)
;	JUMP subroutine to FIBONACCI
;	LOAD return value into R2	(HINT: Which register do we load relative to? Where is the return value in memory relative to where this register is pointing?)						(R5 = x500A)
;	POP input to F(n-2)									(R6 = x500A)
 
;	ADD R1 + R2 -> R0, aka F(n-1) + F(n-2) -> R0
 
END_ALL_CASES
;;;;;;
;	STORE return (R0) into return value on stack	(HINT: Where is the return value for FIBONACCI relative to the frame pointer? Draw a picture of the stack and count the steps between the two.)	(R5 = x500A)
 
;	MAKE stack pointer go to end of frame	(HINT: Which register are we MODIFYING, R5 or R6? The other will serve as the source.)			(R6 = x500A)
 
;	MAKE stack pointer go forward one address			(R6 = x500B)
;	RESTORE R0 to value stored on stack			(HINT: Do we use stack or frame pointer for this? It will be the same one as your loads.)		(R6 = x500B)
 
;	MAKE stack pointer go forward one address			(R6 = x500C)
;	RESTORE R1 to value stored on stack					(R6 = x500C)
 
;	MAKE stack pointer go forward one address			(R6 = x500D)
;	RESTORE R2 to value stored on stack					(R6 = x500D)
 
;	MAKE stack pointer go forward one address			(R6 = x500E)
;	RESTORE R3 to value stored on stack					(R6 = x500E)
 
;	MAKE stack pointer go forward one address			(R6 = x500F)
;	RESTORE R5 to value stored on stack			(HINT: This will restore the previous frame pointer from BEGINNING.)		(R6 = x500F)
 
;	MAKE stack pointer go forward one address			(R6 = x5010)
;	RESTORE R7 to value stored on stack		(HINT: This will restore the return address for the previous function.)			(R6 = x5010)
 
;	POP stack		(HINT: What is left to pop off the stack at this point? Move the SP forward that many locations.)									(R6 = x5011)	
RET
 
.END