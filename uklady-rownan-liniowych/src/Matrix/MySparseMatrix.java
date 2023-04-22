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
}
