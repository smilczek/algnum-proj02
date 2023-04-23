package Matrix;
import java.util.Random;

public abstract class MySparseMatrix {
    protected int numRows;
    protected int numCols;

    protected double[] solution;
    public MySparseMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.solution = new double[numCols];
    }

    public abstract void setElement(int row, int col, double value);

    public abstract double getElement(int row, int col);

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    protected double getSolutionValue(int row) { return this.solution[row]; }

    protected void setSolution(int row, double value) {
        this.solution[row] = value;
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

    protected void subtractSolutionScalar(int destRow, int srcRow, double scalar) {
        double destValue = getSolutionValue(destRow) - (getSolutionValue(srcRow) * scalar);
        setSolution(destRow, destValue);
    }
    public void subtractRowsScalar(int destRow, int srcRow, double scalar) {
        for (int col = 0; col < numCols; col++) {
            double destValue = getElement(destRow, col) - (getElement(srcRow, col) * scalar);
            System.out.println(destValue);
            setElement(destRow, col, destValue);
        }
        subtractSolutionScalar(destRow, srcRow, scalar);
    }

    protected void swapSolution(int row1, int row2) {
        double value1 = getSolutionValue(row1);
        double value2 = getSolutionValue(row2);
        setSolution(row1, value2);
        setSolution(row2, value1);
    }

    public void swapRows(int row1, int row2) {
        for (int col = 0; col < numCols; col++) {
            double value1 = getElement(row1, col);
            double value2 = getElement(row2, col);
            setElement(row1, col, value2);
            setElement(row2, col, value1);
        }
        swapSolution(row1, row2);
    }

    public double generateRandomValue() {
        Random rand = new Random();
        return rand.nextInt((int) - Math.pow(2, 16), (int) Math.pow(2, 16) - 1) / Math.pow(2, 16);
    }

    public void generateDense() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                setElement(row, col, generateRandomValue());
            }
            setSolution(row, generateRandomValue());
        }
    }
    public void gaussianElim() {
        int currRow = 0; // The row we're subtracting from others
        for (int column = 0; column < this.getNumCols() && currRow < this.getNumRows(); column++) {
            double firstElem = this.getElement(currRow, column);
            // Go to the next column if this is not the first non-zero element
            if (firstElem == 0)
                continue;
            // set the first element to 1
            this.divideRow(currRow, firstElem);

            // Subtract current row from the rows below it
            for (int row = currRow + 1; row < this.getNumRows(); row++) {
                this.subtractRowsScalar(row, currRow, this.getElement(row, column));
            }
            currRow++;
        }
    }
    public void reduce() {
        for (int column = 0; column < this.getNumCols(); column++) {
            for (int row = column; row < this.getNumRows(); row++) {
                if (this.getElement(row, column) == 0)
                    continue;
                this.swapRows(row, column);
            }
        }
    }
    public void printMatrix() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(getElement(row, col));
                System.out.print(", ");
            }
            System.out.print(this.getSolutionValue(row));
            System.out.print("\n");
        }
    }
}
