import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;
import Tests.EfficiencyTests;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EfficiencyTests tests = new EfficiencyTests();

        tests.testSparse(100, 3);
//        tests.testBand(100, 3);
//        tests.testDense(100, 3);
    }
}