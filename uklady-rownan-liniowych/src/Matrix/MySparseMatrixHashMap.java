package Matrix;

import java.util.HashMap;
import java.util.Map;

public class MySparseMatrixHashMap {

    private int numRows;
    private int numCols;
    private Map<String, Double> matrixValues;

    public MySparseMatrixHashMap(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.matrixValues = new HashMap<String, Double>();
    }

    public void setElement(int row, int col, double value) {
        if (value != 0) {
            String key = row + "," + col;
            matrixValues.put(key, value);
        }
    }

    public double getElement(int row, int col) {
        String key = row + "," + col;
        if (matrixValues.containsKey(key)) {
            return matrixValues.get(key);
        }
        return 0;
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
                String key = i + "," + j;
                if (matrixValues.containsKey(key)) {
                    System.out.print(matrixValues.get(key) + " ");
                } else {
                    System.out.print("0.0 ");
                }
            }
            System.out.println();
        }
    }
}
