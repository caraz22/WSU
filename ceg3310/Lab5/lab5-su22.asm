.ORIG x3000
;	Your main() function starts here
LD R6, STACK_PTR			;	LOAD the pointer to the bottom of the stack in R6	(R6 = x5013)
ADD R6, R6, #-1				;	Allocate room for your return value 				(R6 = x5012)
ADD R5, R6, #0				;	MAKE your frame pointer R5 point to local variables	(R5 = x5012)
LEA R4, GLOBAL_VARS			;	MAKE your global var pointer R4 point to globals	(R4 = ADDRESS(GLOBAL_VARS))

LEA R0, ARRAY_POINTER		;	LOAD the address of your array pointer
STR R0, R5, #0				;	STORE pointer to array in stack						(R5 = x5012)
ADD R6, R6, #-2				;	MAKE stack pointer go back two addresses			(R6 = x5010)

STR R0, R6, #0				;	STORE pointer to array (input to sumOfSquares)		(R6 = x5010)
ADD R6, R6, #-1				;	MAKE stack pointer go back one address				(R6 = x500F)

LDR R0, R4, #0				;	LOAD MAX_ARRAY_SIZE value into R0
STR R0, R6, #0				;	STORE MAX_ARRAY_SIZE value into stack				(R6 = x500F)

ADD R6, R6, #-1				;	MAKE stack pointer go back one address				(R6 = x500E)
JSR sumOfSquares			;	CALL sumOfSquares() function
LDR R0, R5, #-4				;	LOAD return value of sumOfSquares() into R0			(R5 = x5012)

ADD R6, R6, #1				;	POP input to sumOfSquares off the stack				(R6 = x5010)

STR R0, R5, #-1				;	STORE int total into stack							(R5 = x5012)
STR R0, R5, #1				;	STORE main() return value into stack				(R5 = x5012)

ADD R6, R6, #4				;	POP stack											(R6 = x5014)
HALT

GLOBAL_VARS					;	Your global variables start here
MAX_ARRAY_SIZE	.FILL x0005	;	MAX_ARRAY_SIZE is a global variable and predefined
ARRAY_POINTER	.FILL x0002	;	ARRAY_POINTER points to the top of your array (5 elements)
				.FILL x0003
				.FILL x0005
				.FILL x0000
				.FILL x0001
STACK_PTR		.FILL x5013	;	STACK_PTR is a pointer to the bottom of the stack	(x5013)

sumOfSquares
;	Your sumOfSquares() function starts here
RET

square
;	Your square() function starts here
RET

.END