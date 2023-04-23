import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

public class Main {
    public static void main(String[] args) {
        MySparseMatrixArray mat = new MySparseMatrixArray(3, 3);
        mat.generateSparse();
        mat.saveToFile("martix.txt");
        mat.solveA2();

//        EXAMPLE OF FILE SAVING/LOADING
//        double[][] testarr = new double[][]{{1, 2, 0}, {3, 0, 1}, {0, 0, 5}};
//        MySparseMatrixHashMap testmatrix = new MySparseMatrixHashMap(testarr);
//        testmatrix.saveToFile("file");
//
//        MySparseMatrixArray testmatrix2 = new MySparseMatrixArray("file");
//
//        testmatrix2.printMatrix();
    }
}