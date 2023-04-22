package Matrix.GaussianElim;

import Matrix.MySparseMatrix;
import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

public class Test {
    public static void main(String[] args) {
        MySparseMatrix testMatrix1 = new MySparseMatrixHashMap(5, 5);
        MySparseMatrix testMatrix2 = new MySparseMatrixArray(5, 1);
        testMatrix1.generateDense();
        testMatrix2.generateDense();
        testMatrix1.printMatrix();
//        testMatrix2.printMatrix();
        new Solve(testMatrix1, testMatrix2);
        System.out.println();
        testMatrix1.printMatrix();

    }
}
