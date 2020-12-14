package processor.matrix;

import java.util.Scanner;

public class MatrixMenu {

	/**
	 * This method calls up the menu for manipulating matrices
	 */
	public void run() {
		
		try (Scanner scanner = new Scanner(System.in)) {
			int menu;
			do {
				System.out.println("1. Add matrices");
				System.out.println("2. Multiply matrix by a constant");
				System.out.println("3. Multiply matrices");
				System.out.println("4. Transpose matrix");
				System.out.println("5. Calculate a determinant");
				System.out.println("6. Inverse matrix");
				System.out.println("0. Exit");
				
				System.out.println("Your choice: ");
				menu = scanner.nextInt();
				
				switch (menu) {
				case 1:
					addMatrices(scanner);
					break;
				case 2:
					multiplyMatrixByConstant(scanner);
					break;
				case 3:
					multiplyMatrices(scanner);
					break;
				case 4:
					transpose(scanner);
					break;
				case 5:
					calculateDeterminant(scanner);
					break;
				case 6:
					inverseMatrix(scanner);
				}
			} while (menu != 0);
		}

	}

	/**
	 * This method calls the operation of adding matrices
	 *
	 * @param scanner	the {@link Scanner} input scanner
	 */
	private void addMatrices(Scanner scanner) {
		System.out.print("Enter size of first matrix: ");
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		Matrix matrixA = new Matrix(m, n);
		System.out.println("Enter first matrix:");
		matrixA.loadMatrix(scanner);

		System.out.print("Enter size of second matrix: ");
		m = scanner.nextInt();
		n = scanner.nextInt();
		Matrix matrixB = new Matrix(m, n);
		System.out.println("Enter second matrix:");
		matrixB.loadMatrix(scanner);

		try {
			matrixA.addMatrices(matrixB);
			System.out.println("The result is:");
			matrixA.printMatrix();
		} catch (IllegalArgumentException e) {
			System.out.printf("%s%n%n", e.getMessage());
		}
	}

	/**
	 * This method calls the operation of multiplying the matrix by a constant
	 *
	 * @param scanner	the {@link Scanner} input scanner
	 */
	private void multiplyMatrixByConstant(Scanner scanner) {
		System.out.print("Enter size of matrix: ");
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		Matrix matrix = new Matrix(m, n);
		System.out.println("Enter matrix:");
		matrix.loadMatrix(scanner);

		System.out.print("Enter constant: ");
		double constant = scanner.nextDouble();

		matrix.multiplyMatrixByConstant(constant);
		System.out.println("The result is:");
		matrix.printMatrix();
	}

	/**
	 * This method calls the operation of multiplying the matrix by the matrix
	 *
	 * @param scanner	the {@link Scanner} input scanner
	 */
	private void multiplyMatrices(Scanner scanner) {
		System.out.print("Enter size of first matrix: ");
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		Matrix matrixA = new Matrix(m, n);
		System.out.println("Enter first matrix:");
		matrixA.loadMatrix(scanner);

		System.out.print("Enter size of second matrix: ");
		m = scanner.nextInt();
		n = scanner.nextInt();
		Matrix matrixB = new Matrix(m, n);
		System.out.println("Enter second matrix:");
		matrixB.loadMatrix(scanner);

		try {
			matrixA.multiplyMatrixByAnotherMatrix(matrixB);
			System.out.println("The result is:");
			matrixA.printMatrix();
		} catch (IllegalArgumentException e) {
			System.out.printf("%s%n%n", e.getMessage());
		}
	}

	/**
	 * This method calls up the menu with the choice of matrix transposition
	 *
	 * @param scanner	the {@link Scanner} input scanner
	 */
	private void transpose(Scanner scanner) {
		System.out.println("1. Main diagonal");
		System.out.println("2. Side diagonal");
		System.out.println("3. Vertical line");
		System.out.println("4. Horizontal line");

		System.out.println("Your choice: ");
		int menu = scanner.nextInt();

		System.out.print("Enter matrix size: ");
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		Matrix matrix = new Matrix(m, n);
		System.out.println("Enter matrix:");
		matrix.loadMatrix(scanner);

		switch (menu) {
		case 1:
			matrix.transposeMatrixByMainDiagonal();
			break;
		case 2:
			matrix.transposeMatrixBySideDiagonal();
			break;
		case 3:
			matrix.transposeMatrixVertically();
			break;
		case 4:
			matrix.transposeMatrixHorizontally();
		}
		System.out.println("The result is:");
		matrix.printMatrix();
	}

	/**
	 * This method calls the operation of the matrix determinant calculation
	 *
	 * @param scanner	the {@link Scanner} input scanner
	 */
	private void calculateDeterminant(Scanner scanner) {
		System.out.print("Enter size of matrix: ");
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		if (m == n) {
			SquareMatrix squareMatrix = new SquareMatrix(m);
			System.out.println("Enter matrix:");
			squareMatrix.loadMatrix(scanner);

			System.out.println("The result is:");
			System.out.println(squareMatrix.getDeterminant());
		} else {
			System.out.printf("%s%n%n", "The determinant can be calculated only for the square matrix");
		}
	}

	/**
	 * This method calls the operation of the inverse matrix calculation
	 *
	 * @param scanner	the {@link Scanner} input scanner
	 */
	private void inverseMatrix(Scanner scanner) {
		System.out.print("Enter size of matrix: ");
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		if (m == n) {
			SquareMatrix squareMatrix = new SquareMatrix(m);
			System.out.println("Enter matrix:");
			squareMatrix.loadMatrix(scanner);

			try {
				SquareMatrix inverseMatrix = squareMatrix.getInverseMatrix();
				System.out.println("The result is:");
				inverseMatrix.printMatrix();
			} catch (IllegalStateException e) {
				System.out.printf("%s%n%n", e.getMessage());
			}

		} else {
			System.out.printf("%s%n%n", "The inverse matrix can be calculated only for the square matrix");
		}
	}

}
