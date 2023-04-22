package Matrix;
public class MySparseMatrixArray extends MySparseMatrix {
    private double[][] nonZeroElements;

    public MySparseMatrixArray(int numRows, int numCols) {
        super(numRows, numCols);
        this.nonZeroElements = new double[numRows][numCols];
    }

    @Override
    public void setElement(int row, int col, double value) {
        if (value != 0) {
            nonZeroElements[row][col] = value;
        }
    }

    @Override
    public double getElement(int row, int col) {
        return nonZeroElements[row][col];
    }

    @Override
    public void gaussianElim() {
        for (int row = 0; row < numRows; row++) {
            // Find first non-zero element
            for (int column = 0; column < numCols; column++) {
                if (getElement(row, column) == 0)
                    continue;

            }
        }
    }
}