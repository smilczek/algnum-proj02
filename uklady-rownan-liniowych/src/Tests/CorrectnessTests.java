package Tests;

import ExistingImplementation.GaussianElimination;
import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

import java.io.FileWriter;
import java.io.IOException;

public class CorrectnessTests {
    public void TG_test() throws IOException {
        for (int size = 10; size <= 100; size++) {
            Test(size, 'G');
        }
    }

    public void TW_test() throws IOException {
        for (int size = 10; size <= 100; size++) {
            Test(size, 'W');
        }
    }

    public void TR_test() throws IOException {
        for (int size = 10; size <= 100; size++) {
            Test(size, 'R');
        }
    }

    public void Test(int size, char type) throws IOException {
        MySparseMatrixArray generator = new MySparseMatrixArray(size, size);

        switch (type) {
            case 'G':
                generator.generateDense();
            case 'W':
                generator.generateBand();
            case 'R':
                generator.generateSparse();
        }

        generator.saveToFile("matrix.txt");

        MySparseMatrixArray marray1 = new MySparseMatrixArray("matrix.txt");
        MySparseMatrixArray marray2 = new MySparseMatrixArray("matrix.txt");
        MySparseMatrixHashMap mhash1 = new MySparseMatrixHashMap("matrix.txt");
        MySparseMatrixHashMap mhash2 = new MySparseMatrixHashMap("matrix.txt");
        GaussianElimination mexist = new GaussianElimination();

        marray1.solveA1();
        double[] SA1 = marray1.getSolvedVec();
        marray2.solveA2();
        double[] SA2 = marray2.getSolvedVec();

        mhash1.solveA1();
        double[] HA1 = mhash1.getSolvedVec();
        mhash2.solveA2();
        double[] HA2 = mhash2.getSolvedVec();

        mexist.loadFromFile("matrix.txt");
        double[] E = mexist.lsolve(mexist.A, mexist.B);

        int length = E.length;

//        double[] A1_errors = new double[length];
//        double[] A2_errors = new double[length];

        double A1_error = 0;
        double A2_error = 0;

        for (int i = 0; i < length; i++) {
            A1_error += (Math.abs(E[i] - SA1[i]) + Math.abs(E[i] - SA2[i])) / 2;
            A2_error += (Math.abs(E[i] - HA1[i]) + Math.abs(E[i] - HA2[i])) / 2;
//            double avg_error_A1 = (Math.abs(E[i] - SA1[i]) + Math.abs(E[i] - SA2[i])) / 2;
//            double avg_error_A2 = (Math.abs(E[i] - HA1[i]) + Math.abs(E[i] - HA2[i])) / 2;
//            A1_errors[i] = avg_error_A1;
//            A2_errors[i] = avg_error_A2;
        }

        A1_error /= length;
        A2_error /= length;

//        double[][] errors = new double[][]{A1_errors, A2_errors};
        double[][] errors = new double[][]{{A1_error}, {A2_error}};

        appendToFile(errors, "errors.txt");
    }

    public static void appendToFile(double[][] arr, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, true); // true means append to file
            for (double[] subArr : arr) {
                for (int i = 0; i < subArr.length; i++) {
                    writer.append(Double.toString(subArr[i]));
                    if (i != subArr.length - 1) {
                        writer.append(",");
                    }
                }
                writer.append("/");
            }
            writer.append(System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
