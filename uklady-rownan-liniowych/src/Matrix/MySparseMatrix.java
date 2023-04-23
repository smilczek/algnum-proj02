package Matrix;
import java.io.*;
import java.util.*;

public abstract class MySparseMatrix {
    protected int numRows;
    protected int numCols;

    protected double[] solution;
    protected double[] solvedVec;

    public MySparseMatrix() {

    }

    public MySparseMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.solution = new double[numCols];
        this.solvedVec = new double[numCols];
    }

    public abstract double getElement(int row, int col);
    public abstract void setElement(int row, int col, double value);

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

    protected double getSolvedValue(int row) {
        return this.solvedVec[row];
    }
    protected void setSolvedValue(int row, double value) {
        this.solvedVec[row] = value;
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

    public void generateBand() {
        for (int row = 0; row < Math.min(numRows, numCols); row++) {
            setElement(row, row, generateRandomValue());
            setSolution(row, generateRandomValue());
        }
    }


    protected void calcSolution() {
        for (int diag = this.getNumRows() - 1; diag >= 0; diag--) {
            double calcValue = this.getSolutionValue(diag);
            for (int column = this.getNumCols() - 1; column > diag; column--)
                calcValue -= this.getSolvedValue(column) * this.getElement(diag, column);
            calcValue /= this.getElement(diag, diag);
            this.setSolvedValue(diag, calcValue);
        }
    }
    protected void reduce() {
        int swapRow = 0;
        for (int column = 0; column < this.getNumCols(); column++) {
            for (int row = swapRow; row < this.getNumRows(); row++) {
                if (this.getElement(row, column) == 0)
                    continue;
                if (swapRow != row)
                    this.swapRows(swapRow, row);
                swapRow++;
            }
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
            setSolution(row, generateRandomValue());
        }
    }

    public void solveA1() {
        this.reduce();
        this.printMatrix();
        this.printSolution();
        this.gaussianElim();
        this.printMatrix();
        this.calcSolution();
        this.printSolved();
    }

    public void solveA2() {
        this.printMatrix();
        this.printSolution();
        this.gaussianElim2();
        this.printMatrix();
        this.calcSolution();
        this.printSolved();
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

    public void printSolution() {
        for (double value : this.solution)
            System.out.println(value);
        System.out.println();
    }

    protected void gaussianElim() {
        int currRow = 0; // The row we're subtracting from others
        for (int column = 0; column < this.getNumCols() && currRow < this.getNumRows(); column++) {
            double firstElem = this.getElement(currRow, column);
            // Go to the next column if this is not the first non-zero element
            if (firstElem == 0)
                continue;

            // Subtract current row from the rows below it
            for (int row = currRow + 1; row < this.getNumRows(); row++) {
                this.subtractRowsScalar(row, currRow, this.getElement(row, column) / firstElem);
            }
            currRow++;
        }
    }

    public int findMaxValueRow(int col, int startRow) {
        double maxFactor = getElement(startRow, col);
        int maxRow = startRow;
        for (int row = startRow; row < getNumRows(); row++) {
            if (getElement(row, col) > maxFactor) {
                maxFactor = getElement(row, col);
                maxRow = row;
            }
        }
        return maxRow;
    }

    protected void gaussianElim2() {
        int currRow = 0; // The row we're subtracting from others
        for (int column = 0; column < this.getNumCols() && currRow < this.getNumRows(); column++) {
            double firstElem = this.getElement(currRow, column);
            // Swap rows if this is not the first non-zero element
            if (firstElem == 0)
                swapRows(currRow, findMaxValueRow(column, currRow));

            // Subtract current row from the rows below it
            for (int row = currRow + 1; row < this.getNumRows(); row++) {
                this.subtractRowsScalar(row, currRow, this.getElement(row, column) / firstElem);
            }
            currRow++;
        }
    }

    public void printSolved() {
        for (double value : this.solvedVec)
            System.out.println(value);
        System.out.println();
    }

    public void saveToFile(String filename) throws java.io.IOException {
        FileWriter fw = new FileWriter(filename);
        PrintWriter pw = new PrintWriter(fw);

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                String valStr = Double.toString(getElement(row, col));
                pw.print(valStr + " ");
            }
            pw.println();
        }
        for (double value : solution)
            pw.print(value + " ");
        pw.println();
        pw.close();
        fw.close();
    }

    public double[][] loadFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<String[]> rows = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            String[] row = line.trim().split("\\s+");
            rows.add(row);
        }

        numRows = rows.size();
        numCols = rows.get(0).length;
        double[][] matrix = new double[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                double val = Double.parseDouble(rows.get(row)[col]);
                matrix[row][col] = val;
            }
        }

        br.close();

        return matrix;
    }
}
