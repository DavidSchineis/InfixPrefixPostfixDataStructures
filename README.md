# Infix/Prefix/Postfix Project
>A program implemented in Java and completed during my data structures class.
>Processes an infix expression, outputs postfix, prefix, and solution to the expression using a stack.

## Input
This program will read an infix expression comprised of constants, +-*/ operators, and parentheses. The characters in the input expression must be separated by single spaces.
```
Input Infix Expression: ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )  
```

## Output
The program will then process and write the expression into postfix and prefix. Additionally, it solves the expression and writes it as a double. The characters in the output expressions will be separated by single spaces.
```
Postfix version: 2 3 4 + 5 6 * * +  
Prefix version:  + 2 * + 3 4 * 5 6  
Evaluation: 212.00  
```
