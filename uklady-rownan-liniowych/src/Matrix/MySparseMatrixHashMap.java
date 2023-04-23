package Matrix;

import java.util.HashMap;

public class MySparseMatrixHashMap extends MySparseMatrix {
    private HashMap<String, Double> nonZeroElements;

    // constructor for empty matrix
    public MySparseMatrixHashMap(int numRows, int numCols) {
        super(numRows, numCols);
        this.nonZeroElements = new HashMap<>();
    }

    // constructor for given matrix as a 2d array
    public MySparseMatrixHashMap(double[][] matrix) {
        // just like in MySparseMatrixArray super() needs to be
        // the first thing in the constructor, so it has no names for the arguments
        // it translates to super(numRows, numCols)
        super(matrix.length, matrix[0].length);
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        this.nonZeroElements = new HashMap<>();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if(matrix[row][col] != 0) {
                    this.setElement(row, col, matrix[row][col]);
                }
            }
        }
    }

    @Override
    public void setElement(int row, int col, double value) {
        String key = row + "," + col;
        if (value != 0) {
            nonZeroElements.put(key, value);
        } else {
            nonZeroElements.remove(key);
        }
    }

    @Override
    public double getElement(int row, int col) {
        String key = row + "," + col;
        return nonZeroElements.getOrDefault(key, 0.0);
    }
}
