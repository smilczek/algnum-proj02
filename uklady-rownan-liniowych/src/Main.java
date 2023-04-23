import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
//        MySparseMatrixArray mat = new MySparseMatrixArray(3, 3);
//        mat.generateSparse();
//        mat.saveToFile("matrix.txt");

        MySparseMatrixHashMap mat1 = new MySparseMatrixHashMap("matrix.txt");
        MySparseMatrixArray mat2 = new MySparseMatrixArray("matrix.txt");
//        mat1.printMatrix();
//        mat2.printMatrix();

//        mat1.solveA1();
//        mat2.solveA2();

//        mat1.printSolved();
//        mat2.printSolved();

        EfficiencyTests test = new EfficiencyTests();
        test.testArrayA1(50);

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