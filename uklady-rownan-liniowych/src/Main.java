import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

public class Main {
    public static void main(String[] args) {
        MySparseMatrixArray mat = new MySparseMatrixArray(5, 5);
        mat.generateDense();
        mat.reduce();
        mat.printMatrix();
        mat.gaussianElim();
        mat.printMatrix();
    }
}