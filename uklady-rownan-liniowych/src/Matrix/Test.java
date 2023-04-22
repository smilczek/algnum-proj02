package Matrix;

public class Test {
//    just checking if anything works

    public static void main(String[] args) {
        MySparseMatrixArray testMatrix = new MySparseMatrixArray(8, 10);
        testMatrix.generateBand();
        testMatrix.printMatrix();
    }
}
