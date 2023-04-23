package Matrix;
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
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        this.nonZeroElements = new double[numRows][numCols];

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
        nonZeroElements[row][col] = value;
    }

    @Override
    public double getElement(int row, int col) {
        return nonZeroElements[row][col];
    }
}