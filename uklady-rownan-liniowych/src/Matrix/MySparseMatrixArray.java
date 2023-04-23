package Matrix;

import java.io.IOException;

public class MySparseMatrixArray extends MySparseMatrix {
    private double[][] nonZeroElements;

    // constructor for empty matrix
    public MySparseMatrixArray(int numRows, int numCols) {
        super(numRows, numCols);
        this.nonZeroElements = new double[numRows][numCols];
    }

    // constructor for given matrix as a 2d array
    public MySparseMatrixArray(double[][] matrix) {
        // found out super() needs to be the first thing in the constructor,
        // so it has no names for the arguments
        // it translates to super(numRows, numCols)
        super(matrix.length, matrix[0].length);
        arrayToMatrix(matrix);
    }

    public MySparseMatrixArray(String filename) throws IOException {
        double[][] array = loadFromFile(filename);
        this.numRows = array.length;
        this.numCols = array[0].length;

        arrayToMatrix(array);
    }

    public void arrayToMatrix(double[][] array) {
        int numRows = array.length;
        int numCols = array[0].length;

        this.nonZeroElements = new double[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if(array[row][col] != 0) {
                    this.setElement(row, col, array[row][col]);
                }
            }
        }
    }

    @Override
    public void setElement(int row, int col, double value) {
        nonZeroElements[row][col] = value;
    }

    @Override
    public double getElement(int row, int col) {
        return nonZeroElements[row][col];
    }
}