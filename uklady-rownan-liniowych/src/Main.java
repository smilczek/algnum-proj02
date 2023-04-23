import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        MySparseMatrixArray mat = new MySparseMatrixArray(3, 3);
//        mat.generateSparse();
//        mat.solve();

        double[][] testarr = new double[][]{{1, 2, 0}, {3, 0, 1}, {0, 0, 5}};
        MySparseMatrixHashMap testmatrix = new MySparseMatrixHashMap(testarr);
        testmatrix.saveToFile("file");

        MySparseMatrixArray testmatrix2 = new MySparseMatrixArray("file");

        testmatrix2.printMatrix();
    }
}