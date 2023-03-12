.ORIG x4000
;WRITE YOUR CODE HERE

STI R6, STACK_R6                ; Store R6 to the address held at STACK_R6
LDI R6, STACK                   ; Load STACK into R6
ST R0, R6                       ; Store contents of R0 to the memory location CURRENTLY held by R6
STR R1, R6, #-1                 ; Store contents of R1 to the stack using an offset 1 word behind the stack pointer
STR R2, R6, #-2                 ; Store contents of R1 to the stack using an offset 2 words behind the stack pointer
STR R3, R6, #-3                 ; Store contents of R1 to the stack using an offset 3 words behind the stack pointer
STR R4, R6, #-4                 ; Store contents of R1 to the stack using an offset 4 words behind the stack pointer
STR R5, R6, #-5                 ; Store contents of R1 to the stack using an offset 5 words behind the stack pointer
STR R7, R6, #-7                 ; Store contents of R1 to the stack using an offset 7 words behind the stack pointer

LEA R0, PROMPT                  ; Load the address of PROMPT into R0
PUTS                            ; PUTS TRAP function

LD R1, CHARACTER_COUNT          ; Load the CHARACTER_COUNT variable into R1

CHAR_GET                        ; Defining CHAR_GET
GETC                            ; Calling GETC
OUT                             ; OUT TRAP function

LD R2, X_VAL                    ; Load X_VAL into R2
NOT R2, R2                      ; 2's complement on R2
AND R2, R0, R2                  ; Comparing contents of R2 and R0
BRz X_DETECTED                  ; Branching if ZERO to X_DETECTED

LD R2, ALPHA_VAL                ; Load ALPHA_VAL into R2
NOT R2, R2                      ; 2's complement on R2
AND R2, R0, R2                  ; Comparing contents of R2 and R0
BRzp ALPHA_DETECTED             ; Branching if NON-NEGATIVE to ALPHA_DETECTED

LD R2, NUMERIC_VAL              ; Load NUMERIC_VAL into R2
NOT R2, R2                      ; 2's complement on R2
AND R2, R0, R2                  ; Comparing contents of R2 and R0
BRzp NUMERIC_DETECTED           ; Branching if NON-NEGATIVE to NUMERIC_DETECTED
BRnzp CHAR_FINISHED             ; Branching unconditionally to CHAR_FINISHED

ALPHA_DETECTED                  ; Detects if the character was alphabetical and converts it from ASCII to HEX
ADD R2, R2, #10                 ; Add R2 and 10
ADD R3, R1, #-1                 ; Decrement R1 by 1 and store in R3
BRz CHAR_FINISHED               ; Branch if ZERO to CHAR_FINISHED
ADD R3, R3, #-1                 ; Decrement R3 by 1
BRnzp BITSHIFT                  ; Branch unconditionally to BITSHIFT

NUMERIC_DETECTED                ; Detects if the character was numeric and converts it from ASCII to HEX
AND R3, R1, #-1                 ; Checking if BITSHIFT is necessary
BRz CHAR_FINISHED               ; Brand if ZERO to CHAR_FINISHED
ADD R3, R3, #-1                 ; Decrement R3 by 1

BITSHIFT                        ; Performs a 4-bit left shift, sometimes repeatedly
ADD R2, R2, R2                  ; Add R2 to itself
ADD R2, R2, R2                  ; Add R2 to itself
ADD R2, R2, R2                  ; Add R2 to itself
ADD R2, R2, R2                  ; Add R2 to itself
ADD R3, R3, #-1                 ; Decrement R3 by 1
BRzp BITSHIFT                   ; Branch if NON-NEGATIVE to BITSHIFT
BRnzp CHAR_FINISHED             ; Branch unconditionally to CHAR_FINISHED

X_DETECTED                      ; Indicator that detects an x read in
CHAR_FINISHED                   ; Indicates a character is shifted over the proper amount
ADD R4, R2, R4                  ; Add R2 to R4
ADD R1, R1, #-1                 ; Decrement R1 by 1
BRp CHAR_GET                    ; Branch if POSITIVE to CHAR_GET

LD R0, NEWLINE_VAL              ; Load NEWLINE_VAL into R0
OUT                             ; OUT TRAP call
AND R0, R0, #0                  ; Clear R0
ADD R0, R0, R4                  ; Put R4 into R0

LDR R1, R6, #-1                 ; Load contents at memory location 1 word behind R6 into R1
LDR R2, R6, #-2                 ; Load contents at memory location 2 word behind R6 into R2
LDR R3, R6, #-3                 ; Load contents at memory location 3 word behind R6 into R3
LDR R4, R6, #-4                 ; Load contents at memory location 4 word behind R6 into R4
LDR R5, R6, #-5                 ; Load contents at memory location 5 word behind R6 into R5
LDR R7, R6, #-7                 ; Load contents at memory location 7 word behind R6 into R7
LDR R6, R6, #-6                 ; Load contents at memory location 6 word behind R6 into R6

RET

STACK .FILL x4700
STACK_R6 .FILL x46FA
CHARACTER_COUNT .FILL #5
PROMPT .STRINGZ "Enter your address: \n"
X_VAL .FILL x0078
ALPHA_VAL XFILL x0041
NUMERIC_VAL .FILL x0030
NEWLINE_VAL .FILL x000A

.END