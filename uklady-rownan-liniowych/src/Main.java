import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
//        MySparseMatrixArray mat = new MySparseMatrixArray(3, 3);
//        mat.generateSparse();
//        mat.saveToFile("matrix.txt");

//        MySparseMatrixHashMap mat1 = new MySparseMatrixHashMap("matrix.txt");
//        MySparseMatrixArray mat2 = new MySparseMatrixArray("matrix.txt");
//        mat1.printMatrix();
//        mat2.printMatrix();

//        mat1.solveA1();
//        mat2.solveA2();

//        mat1.printSolved();
//        mat2.printSolved();

        EfficiencyTests test = new EfficiencyTests();
        test.testSparseArray(50);

    }
}