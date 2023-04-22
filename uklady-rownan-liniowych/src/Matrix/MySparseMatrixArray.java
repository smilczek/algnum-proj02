package Matrix;
public class MySparseMatrixArray extends MySparseMatrix {
    private double[][] nonZeroElements;

    public MySparseMatrixArray(int numRows, int numCols) {
        super(numRows, numCols);
        this.nonZeroElements = new double[numRows][numCols];
    }

    @Override
    public void setElement(int row, int col, double value) {
//        no clue jak jakos efficiently usuwac elementy z nonZeroElements a to jest potrzebne
//        ktos madry musi popatrzec
//        bo przepisywanie calej array za kazdym razem nie bedzie chyba time efficient

//        if (value != 0) {
        nonZeroElements[row][col] = value;
//        }
    }

    @Override
    public double getElement(int row, int col) {
        return nonZeroElements[row][col];
    }


}
