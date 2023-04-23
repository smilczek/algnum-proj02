import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

import Tests.EfficiencyTests;
import Tests.CorrectnessTests;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws java.io.IOException {
        CorrectnessTests tester = new CorrectnessTests();
//        tester.TG_test();
//        tester.TR_test();
//        tester.TW_test();

//        MySparseMatrixArray mat = new MySparseMatrixArray(3, 3);
//        mat.generateSparse();
//        mat.saveToFile("matrix.txt");
//
//        MySparseMatrixHashMap mat1 = new MySparseMatrixHashMap("matrix.txt");
//        MySparseMatrixArray mat2 = new MySparseMatrixArray("matrix.txt");
//        GaussianElimination existing = new GaussianElimination();
//        existing.loadFromFile("matrix.txt");
//        mat1.printMatrix();
//        mat2.printMatrix();

//        mat1.solveA1();
//        mat2.solveA2();
//        existing.lsolve(existing.A, existing.B);
//
//        mat1.printSolved();
//        mat2.printSolved();
//        EXAMPLE OF FILE SAVING/LOADING
//        double[][] testarr = new double[][]{{1, 2, 0}, {3, 0, 1}, {0, 0, 5}};
//        MySparseMatrixHashMap testmatrix = new MySparseMatrixHashMap(testarr);
//        testmatrix.saveToFile("file");
//
//        MySparseMatrixArray testmatrix2 = new MySparseMatrixArray("file");
//
//        testmatrix2.printMatrix();

        EfficiencyTests tests = new EfficiencyTests();

        tests.testSparse(100, 3);
        tests.testBand(100, 3);
        tests.testDense(100, 3);
    }
}