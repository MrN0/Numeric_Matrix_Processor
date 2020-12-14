package processor.matrix;

/**
 * This class represents a square matrix and contains methods that perform
 * operations on it
 */
public class SquareMatrix extends Matrix {
	/**
	 * Constructor to create the square matrix
	 *
	 * @param length	the {@code int} number of rows and columns of the matrix
	 */
	public SquareMatrix(int length) {
		super(length, length);
	}

	/**
	 * This method calculates the determinant of the matrix
	 *
	 * @return		the {@code double} determinant of the matrix
	 */
	public double getDeterminant() {
		if (getRows() == 1) {
			return this.matrix[0][0];
		} else {
			return calculateDeterminant(this.matrix);
		}
	}

	/**
	 * This method calculates and returns the inverse matrix of this matrix
	 * (InverseMatrix = (1 / MatrixDeterminant) * Adjoint(Matrix))
	 *
	 * @return		the {@link SquareMatrix} inverse of a matrix
	 * @throws		IllegalStateException if the inversion of this matrix does 
	 * 				not exist
	 */
	public SquareMatrix getInverseMatrix() throws IllegalStateException {
		double determinant = getDeterminant();
		if (determinant == 0) {
			throw new IllegalStateException("Error: the inversion of this matrix does not exist.");
		}

		// define the matrix for the inverse matrix
		SquareMatrix inverseMatrix = new SquareMatrix(rows);
		// calculate the first part of the formula
		double x = 1 / determinant;

		// loop through the matrix
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				// get subMatrix
				double[][] subMatrix = getSubMatrix(matrix, i, j);
				// calculate the minor
				double minor = calculateDeterminant(subMatrix);
				// calculate the cofactor, multiply by first part of the formula number and
				// instantly transpose diagonally
				inverseMatrix.matrix[j][i] = x * (Math.pow(-1, (i + 1) + (j + 1)) * minor);
			}
		}
		// return result
		return inverseMatrix;
	}
	
	/**
	 * This method is recursive which calculates the determinant of the 'n'-order
	 * matrix
	 *
	 * @param matrix	the {@code double} matrix to calculate its determinant
	 * @return			the {@code double} determinant of the matrix
	 */
	private double calculateDeterminant(double[][] matrix) {
		// return the determinant of a 2-order matrix
		if (matrix.length == 2) {
			return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		} else {
			// define the determinant
			double determinant = 0;
			
			// loop through the first row of the matrix
			for (int column = 0; column < matrix.length; column++) {
				// define the number 'n'
				double n = matrix[0][column];
				// get the subMatrix relative to the number 'n'
				double[][] subMatrix = getSubMatrix(matrix, 0, column);
				// calculate the minor for the number 'n'
				double minor = calculateDeterminant(subMatrix);
				// calculate the cofactor
				double cofactor = Math.pow(-1, 1 + (column + 1)) * minor;
				// multiply the number by the cofactor and add the result to the determinant
				determinant += n * cofactor;
			}
			// return a calculated determinant
			return determinant;
		}
	}

	/**
	 * This method obtains a sub matrix relative to the coordinates of the number
	 *
	 * @param matrix 	the {@code double} super matrix
	 * @param row    	the {@code int} row that contains the number
	 * @param column	the {@code int} column that contains the number
	 * @return			the {@code double} sub matrix relative to the coordinates 
	 * 					of the number
	 */
	private double[][] getSubMatrix(double[][] matrix, int row, int column) {
		// define the sub matrix of the matrix
		double[][] subMatrix = new double[matrix.length - 1][matrix.length - 1];
		// define pointers to the desired number in the matrix
		int rowPointer = 0;
		int columnPointer = 0;

		// fill the subMatrix
		for (int i = 0; i < subMatrix.length; i++) {
			// skip unnecessary row
			if (rowPointer == row) {
				rowPointer++;
			}
			for (int j = 0; j < subMatrix.length; j++) {
				// skip unnecessary column
				if (columnPointer == column) {
					columnPointer++;
				}
				// add a number to the subMatrix
				subMatrix[i][j] = matrix[rowPointer][columnPointer++];
			}
			columnPointer = 0;
			rowPointer++;
		}
		// return subMatrix;
		return subMatrix;
	}
}
