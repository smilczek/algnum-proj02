package Matrix;
import java.util.Random;

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

    public void newSubtractRows(int destRow, int srcRow, double multiplier) {
        for (int col = 0; col < numCols; col++) {
            double destValue = getElement(destRow, col) - getElement(srcRow, col) * multiplier;
            setElement(destRow, col, destValue);
        }
    }

    public void swapRows(int row1, int row2) {
        for (int col = 0; col < numCols; col++) {
            double value1 = getElement(row1, col);
            double value2 = getElement(row2, col);
            setElement(row1, col, value2);
            setElement(row2, col, value1);
        }
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
        }
    }
    
    public void generateBand() {
        for (int row = 0; row < Math.min(numRows, numCols); row++) {
            setElement(row, row, generateRandomValue());
        }
    }
    
    public void generateSparse() {
        generateBand();
        Random chance = new Random();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (chance.nextDouble() > 0.8) {
                    setElement(row, col, generateRandomValue());
                }
            }
        }
    }

    public void printMatrix() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(getElement(row, col));
                System.out.print(", ");
            }
            System.out.print("\n");
        }
    }
}
