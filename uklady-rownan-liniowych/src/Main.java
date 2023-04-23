import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

public class Main {
    public static void main(String[] args) {
        MySparseMatrixArray mat = new MySparseMatrixArray(3, 3);
        mat.generateDense();
        mat.solve();
    }
}