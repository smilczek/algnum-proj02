package Matrix;

import java.util.HashMap;

public class MySparseMatrixHashMap extends MySparseMatrix {
    private HashMap<String, Double> nonZeroElements;

    public MySparseMatrixHashMap(int numRows, int numCols) {
        super(numRows, numCols);
        this.nonZeroElements = new HashMap<>();
    }

    @Override
    public void setElement(int row, int col, double value) {
        String key = row + "," + col;
        if (value != 0) {
            nonZeroElements.put(key, value);
        } else {
            nonZeroElements.remove(key);
        }
    }

    @Override
    public double getElement(int row, int col) {
        String key = row + "," + col;
        return nonZeroElements.getOrDefault(key, 0.0);
    }
}
