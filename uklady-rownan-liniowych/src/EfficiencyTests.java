import Matrix.MySparseMatrix;
import Matrix.MySparseMatrixArray;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EfficiencyTests {

    public void writeToFile(String filename, long[] array) throws java.io.IOException {
        FileWriter fw = new FileWriter(filename);
        PrintWriter pw = new PrintWriter(fw);
        for (long item : array) {
            pw.println(item);
        }
        pw.println();
        pw.close();
        fw.close();
    }

    public void testArrayA1(int numRounds) throws IOException {

        long[] times = new long[numRounds];
        for (int round = 3; round < numRounds + 3; round++) {
            MySparseMatrix sparseMatrix = new MySparseMatrixArray(round, round);
            sparseMatrix.generateSparse();
            sparseMatrix.saveToFile("matrix.txt");

            long startTime = System.nanoTime();
            sparseMatrix.solveA1();
            long endTime = System.nanoTime();

            times[round-3] = (endTime - startTime);
        }
        writeToFile("sparseAA1", times);

    }

}
