package processor.matrix;

import java.util.Scanner;

/**
 * This class represents a rectangular matrix and contains methods that perform
 * operations on it
 */
public class Matrix {
	// the number of rows in the matrix
	protected int rows;
	// the number of columns in the matrix
	protected int columns;
	// the array representing the matrix
	protected double[][] matrix;

	/**
	 * Constructor to create the rectangular matrix
	 *
	 * @param rows    the {@code int} number of rows of the matrix
	 * @param columns the {@code int} number of columns of the matrix
	 */
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.matrix = new double[rows][columns];
	}

	/**
	 * This method adds the given matrix to this matrix 
	 * (adds each element of this matrix with the element of a given matrix)
	 *
	 * @param matrix						the {@link Matrix} to add
	 * @throws IllegalArgumentException		if matrices are not the same size
	 */
	public void addMatrices(Matrix matrix) throws IllegalArgumentException {
		// check whether both matrices are the same size
		if (rows != matrix.getRows() || columns != matrix.getColumns()) {
			throw new IllegalArgumentException("Error: the given matrix must have the same size as this matrix");
		}

		// add matrices
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.matrix[i][j] += matrix.getMatrix()[i][j];
			}
		}
	}

	/**
	 * This method multiplies the matrix by the constant 
	 * (multiplies each element of the matrix with the constant)
	 *
	 * @param constant		the {@code double} number - constant for multiplication
	 */
	public void multiplyMatrixByConstant(double constant) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.matrix[i][j] *= constant;
			}
		}
	}

	/**
	 * This method multiplies this matrix by the given matrix
	 * <p>
	 * The sizes of the matrices can be different: the only restriction is that the
	 * number of columns in the first matrix should equal the number of rows for the
	 * second matrix.
	 * <p>
	 * The resulting matrix has 'n' rows and 'k' columns, where every element is a
	 * sum of the multiplication of 'm' elements across the rows of matrix 'A' by
	 * 'm' elements down the columns of matrix 'B'.
	 *
	 * @param matrix						the {@link Matrix} to multiply
	 * @throws IllegalArgumentException		if the number of columns in the given matrix
	 *                                  	does not match the number of rows
	 */
	public void multiplyMatrixByAnotherMatrix(Matrix matrix) throws IllegalArgumentException {
		// check that the number of columns in this matrix is equal to the number of
		// rows for the given matrix
		if (this.columns != matrix.getRows()) {
			throw new IllegalArgumentException(
					"Error: The number of columns in the given matrix does not match the number of rows");
		}

		// define the matrix that is the result of multiplication of matrices
		double[][] result = new double[this.rows][matrix.getColumns()];

		// loop through the whole matrix
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < matrix.getColumns(); j++) {
				// sum of the multiplication of the elements
				double sum = 0.0;
				// loop through the length of 'matrixA' row and 'matrixB' column
				for (int k = 0; k < this.columns; k++) {
					// multiply the elements and add to the sum
					sum += (this.matrix[i][k]) * (matrix.getMatrix()[k][j]);
				}
				// apply sum to the matrix
				result[i][j] = sum;
			}
		}

		// override new data
		this.matrix = result;
	}

	/**
	 * This method transposes the matrix along the main diagonal
	 */
	public void transposeMatrixByMainDiagonal() {
		// define rows and columns for the new array
		int transposedRows = columns;
		int transposedColumns = rows;
		// define the array representing the transposed matrix
		double[][] arr = new double[transposedRows][transposedColumns];
		// transpose the matrix along the main diagonal
		for (int i = 0; i < transposedRows; i++) {
			for (int j = 0; j < transposedColumns; j++) {
				arr[i][j] = matrix[j][i];
			}
		}
		// override new data
		rows = transposedRows;
		columns = transposedColumns;
		matrix = arr;
	}

	/**
	 * This method transposes the matrix along the side diagonal
	 */
	public void transposeMatrixBySideDiagonal() {
		// define rows and columns for the new array
		int transposedRows = columns;
		int transposedColumns = rows;
		// define the array representing the transposed matrix
		double[][] arr = new double[transposedRows][transposedColumns];
		// transpose the matrix along the side diagonal
		for (int i = 0; i < transposedRows; i++) {
			for (int j = 0; j < transposedColumns; j++) {
				arr[i][j] = matrix[columns - j - 1][rows - i - 1];
			}
		}
		// override new data
		rows = transposedRows;
		columns = transposedColumns;
		matrix = arr;
	}

	/**
	 * This method transposes the matrix horizontally
	 */
	public void transposeMatrixHorizontally() {
		int times = rows / 2;
		// loop vertically to the middle of the matrix
		for (int i = 0; i < times; i++) {
			// loop through columns
			for (int j = 0; j < columns; j++) {
				// swap items
				double tmp = matrix[i][j];
				matrix[i][j] = matrix[rows - 1 - i][j];
				matrix[rows - 1 - i][j] = tmp;
			}
		}
	}

	/**
	 * This method transposes the matrix vertically
	 */
	public void transposeMatrixVertically() {
		int times = rows / 2;
		// loop through rows
		for (int i = 0; i < rows; i++) {
			// loop horizontally to the middle of the matrix
			for (int j = 0; j < times; j++) {
				// swap items
				double tmp = matrix[i][j];
				matrix[i][j] = matrix[i][rows - 1 - j];
				matrix[i][rows - 1 - j] = tmp;
			}
		}
	}

	/**
	 * This method fills the matrix with numbers from the input scanner
	 *
	 * @param scanner	the {@link Scanner} for entering numbers
	 */
	public void loadMatrix(Scanner scanner) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = scanner.nextDouble();
			}
		}
	}

	/**
	 * This method prints a matrix in the console
	 */
	public void printMatrix() {
		for (double[] doubles : matrix) {
			for (double anDouble : doubles) {
				System.out.print(anDouble + " ");
			}
			System.out.println();
		}
	}

	// Getters
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public double[][] getMatrix() {
		return matrix;
	}
}
