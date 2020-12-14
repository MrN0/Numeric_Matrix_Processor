# Numeric Matrix Processor
Matrices have a wide range of applications in programming: they're used for digital image processing, graph representation and algorithms on a graph, graphic effects, applied math, statistics, and much more.

## Table of Contents
* [About this program](#about-this-program)
* [Technologies](#technologies)
* [Program Description](#program-description)
* [Examples](#examples)

## About this program
This project is a solution to the problem of JetBrains Academy - "Numeric Matrix Processor".
The program performs a variety of operations on matrices including addition, multiplication, finding the determinant, and dealing with inverse matrices.

##Technologies
- JDK 8

## Program Description
The program performs such operations:
1. Add matrices
2. Multiply matrix by a constant
3. Multiply matrix by matrix
4. Transpose matrix by:
	- main diagonal
	- side diagonal
	- vertical line
	- horizontal line
5. Calculate a determinant
6. Inverse matrix

According to the selection, enter the requested data and confirm the selection by pressing **Enter** button

## Examples
The greater-than symbol followed by a space ( **>** ) represents the user input. Note that it's not part of the input.

```
1. Add matrices
2. Multiply matrix by a constant
3. Multiply matrices
4. Transpose matrix
5. Calculate a determinant
6. Inverse matrix
0. Exit
Your choice: > 6
Enter matrix size: > 3 3
Enter matrix:
> 2 -1 0
> 0 1 2
> 1 1 0
The result is:
 0.33   0  0.33
-0.33   0  0.66
 0.16 0.5 -0.33

1. Add matrices
2. Multiply matrix by a constant
3. Multiply matrices
4. Transpose matrix
5. Calculate a determinant
6. Inverse matrix
0. Exit
Your choice: > 6
Enter matrix size: > 2 2
Enter matrix:
> 2 1
> 4 2
This matrix doesn't have an inverse.

1. Add matrices
2. Multiply matrix by a constant
3. Multiply matrices
4. Transpose matrix
5. Calculate a determinant
6. Inverse matrix
0. Exit
Your choice: > 0
```