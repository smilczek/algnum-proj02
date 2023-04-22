package Matrix;

public class MySparseMatrixArray {
    private int numRows;
    private int numCols;
    private double[][] matrixValues;

    public MySparseMatrixArray(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.matrixValues = new double[numRows][numCols];
    }

    public void setElement(int row, int col, double value) {
        matrixValues[row][col] = value;
    }

    public double getElement(int row, int col) {
        return matrixValues[row][col];
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void printMatrix() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrixValues[i][j] != 0) {
                    System.out.print(matrixValues[i][j] + " ");
                } else {
                    System.out.print("0.0 ");
                }
            }
            System.out.println();
        }
    }
}
