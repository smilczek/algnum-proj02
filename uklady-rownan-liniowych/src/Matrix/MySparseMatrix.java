package Matrix;

public abstract class MySparseMatrix {
    protected int numRows;
    protected int numCols;

    public MySparseMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
    }

    public abstract void setElement(int row, int col, double value);

    public abstract double getElement(int row, int col);

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getFirstNonZeroIndex(int row) {
        for (int col = 0; col < numCols; col++) {
            if (getElement(row, col) != 0) {
                return col;
            }
        }
        return -1;
    }

    public void multiplyRow(int row, double scalar) {
        for (int col = 0; col < numCols; col++) {
            double value = getElement(row, col) * scalar;
            setElement(row, col, value);
        }
    }

    public void divideRow(int row, double scalar) {
        for (int col = 0; col < numCols; col++) {
            double value = getElement(row, col) / scalar;
            setElement(row, col, value);
        }
    }

    public void addRows(int destRow, int srcRow) {
        for (int col = 0; col < numCols; col++) {
            double destValue = getElement(destRow, col) + getElement(srcRow, col);
            setElement(destRow, col, destValue);
        }
    }

    public void subtractRows(int destRow, int srcRow) {
        for (int col = 0; col < numCols; col++) {
            double destValue = getElement(destRow, col) - getElement(srcRow, col);
            setElement(destRow, col, destValue);
        }
    }

}
