package ExistingImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 *
 * This is a modified solution found on the internet
 *
 ******************************************************************************/

public class GaussianElimination {

    public double[][] A;
    public double [] B;
    private static final double EPSILON = 1e-10;

    // Gaussian elimination with partial pivoting
    public static double[] lsolve(double[][] A, double[] b) {
        int n = b.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

            // singular or nearly singular
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new ArithmeticException("Matrix is singular or nearly singular");
            }

            // pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }

//        System.out.println("Existing solution:");
//        for (int i = 0; i < x.length; i++) {
//            System.out.println(x[i]);
//        }
//        System.out.println();

        return x;
    }

    public void loadFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<String[]> rows = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            String[] row = line.trim().split("\\s+");
            rows.add(row);
        }

        int numRows = rows.size();
        int numCols = rows.get(0).length;
        double[][] matrix = new double[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                double val = Double.parseDouble(rows.get(row)[col]);
                matrix[row][col] = val;
            }
        }

        br.close();


        numRows = matrix.length - 1;
        numCols = matrix[0].length;

        this.A = new double[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                this.A[row][col] = matrix[row][col];
            }
        }
        this.B = matrix[matrix.length - 1].clone();
    }

}