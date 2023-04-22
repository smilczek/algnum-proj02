package Matrix.GaussianElim;
import Matrix.MySparseMatrix;


public class Solve {

    protected MySparseMatrix A;
    protected MySparseMatrix B;
    protected MySparseMatrix X;

    public Solve(MySparseMatrix A, MySparseMatrix B) {
        this.A = A;
        this.B = B;

        reduceMatrix();

    }
    public void reduceMatrix() {
        for (int col = 0; col < Math.min(A.getNumCols(), A.getNumRows()); col++) {
            reduceColumn(col, col);
        }
    }

    public void reduceColumn(int columnIndex, int startRow) {
        double baseFactor = A.getElement(startRow, columnIndex);

//        czesciowy wybor elementu podstawowego maybe?
        if (baseFactor == 0.0) {
            A.swapRows(startRow, findMaxValueRow(columnIndex, startRow));
            B.swapRows(startRow, findMaxValueRow(columnIndex, startRow));
        }

        for (int row = startRow + 1; row < A.getNumRows(); row++) {
            A.newSubtractRows(row, startRow, A.getElement(row, columnIndex)/baseFactor);
            B.newSubtractRows(row, startRow, A.getElement(row, columnIndex)/baseFactor);
        }
    }

    public int findMaxValueRow(int col, int startRow) {
        double maxFactor = A.getElement(startRow, col);
        int maxRow = startRow;
        for (int row = startRow; row < A.getNumRows(); row++) {
            if (A.getElement(row, col) > maxFactor) {
                maxFactor = A.getElement(row, col);
                maxRow = row;
            }
        }
        return maxRow;
    }

    public void solveReducedMatrix() {

    }

    public void solveRow(int row) {

    }

}
