package Tests;

import ExistingImplementation.GaussianElimination;
import Matrix.MySparseMatrix;
import Matrix.MySparseMatrixArray;
import Matrix.MySparseMatrixHashMap;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

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


    public void testSparse(Integer numRounds, Integer step) throws IOException {

        long[] timesArr1 = new long[numRounds];
        long[] timesArr2 = new long[numRounds];
        long[] timesHash1 = new long[numRounds];
        long[] timesHash2 = new long[numRounds];
        long[] timesEx = new long[numRounds];

        int currSize = 10;

        for (int round = 0; round < numRounds; round++) {
            System.out.println(currSize);
            MySparseMatrix sparseMatrixArr1 = new MySparseMatrixArray(currSize, currSize);
            sparseMatrixArr1.generateSparse();
            sparseMatrixArr1.saveToFile("matrix.txt");

            long startTime = System.nanoTime();
            sparseMatrixArr1.solveA1();
            long endTime = System.nanoTime();
            timesArr1[round] = (endTime - startTime);

            MySparseMatrix sparseMatrixArr2 = new MySparseMatrixArray("matrix.txt");

            startTime = System.nanoTime();
            sparseMatrixArr2.solveA1();
            endTime = System.nanoTime();
            timesArr2[round] = (endTime - startTime);


            MySparseMatrix sparseMatrixHash1 = new MySparseMatrixHashMap("matrix.txt");

            startTime = System.nanoTime();
            sparseMatrixHash1.solveA1();
            endTime = System.nanoTime();
            timesHash1[round] = (endTime - startTime);

            MySparseMatrix sparseMatrixHash2 = new MySparseMatrixHashMap("matrix.txt");
            startTime = System.nanoTime();
            sparseMatrixHash2.solveA2();
            endTime = System.nanoTime();
            timesHash2[round] = (endTime - startTime);

            GaussianElimination sparseMatrixEx = new GaussianElimination();
            sparseMatrixEx.loadFromFile("matrix.txt");

            startTime = System.nanoTime();
            sparseMatrixEx.lsolve(sparseMatrixEx.A, sparseMatrixEx.B);
            endTime = System.nanoTime();
            timesEx[round] = (endTime - startTime);

            currSize += step;
        }

        writeToFile("sparseArrA1.txt", timesArr1);
        writeToFile("sparseArrA2.txt", timesArr2);
        writeToFile("sparseHashA1.txt", timesHash1);
        writeToFile("sparseHashA2.txt", timesHash2);
        writeToFile("sparseEx.txt", timesEx);

    }

    public void testBand(Integer numRounds, Integer step) throws IOException {

        long[] timesArr1 = new long[numRounds];
        long[] timesArr2 = new long[numRounds];
        long[] timesHash1 = new long[numRounds];
        long[] timesHash2 = new long[numRounds];
        long[] timesEx = new long[numRounds];

        int currSize = 10;

        for (int round = 0; round < numRounds; round++) {
            System.out.println(currSize);
            MySparseMatrix sparseMatrixArr1 = new MySparseMatrixArray(currSize, currSize);
            sparseMatrixArr1.generateBand();
            sparseMatrixArr1.saveToFile("matrix.txt");

            long startTime = System.nanoTime();
            sparseMatrixArr1.solveA1();
            long endTime = System.nanoTime();
            timesArr1[round] = (endTime - startTime);

            MySparseMatrix sparseMatrixArr2 = new MySparseMatrixArray("matrix.txt");

            startTime = System.nanoTime();
            sparseMatrixArr2.solveA1();
            endTime = System.nanoTime();
            timesArr2[round] = (endTime - startTime);


            MySparseMatrix sparseMatrixHash1 = new MySparseMatrixHashMap("matrix.txt");

            startTime = System.nanoTime();
            sparseMatrixHash1.solveA1();
            endTime = System.nanoTime();
            timesHash1[round] = (endTime - startTime);

            MySparseMatrix sparseMatrixHash2 = new MySparseMatrixHashMap("matrix.txt");
            startTime = System.nanoTime();
            sparseMatrixHash2.solveA2();
            endTime = System.nanoTime();
            timesHash2[round] = (endTime - startTime);

            GaussianElimination sparseMatrixEx = new GaussianElimination();
            sparseMatrixEx.loadFromFile("matrix.txt");

            startTime = System.nanoTime();
            sparseMatrixEx.lsolve(sparseMatrixEx.A, sparseMatrixEx.B);
            endTime = System.nanoTime();
            timesEx[round] = (endTime - startTime);

            currSize += step;
        }

        writeToFile("bandArrA1.txt", timesArr1);
        writeToFile("bandArrA2.txt", timesArr2);
        writeToFile("bandHashA1.txt", timesHash1);
        writeToFile("bandHashA2.txt", timesHash2);
        writeToFile("bandEx.txt", timesEx);

    }

    public void testDense(Integer numRounds, Integer step) throws IOException {

        long[] timesArr1 = new long[numRounds];
        long[] timesArr2 = new long[numRounds];
        long[] timesHash1 = new long[numRounds];
        long[] timesHash2 = new long[numRounds];
        long[] timesEx = new long[numRounds];

        int currSize = 10;

        for (int round = 0; round < numRounds; round++) {
            System.out.println(currSize);
            MySparseMatrix sparseMatrixArr1 = new MySparseMatrixArray(currSize, currSize);
            sparseMatrixArr1.generateBand();
            sparseMatrixArr1.saveToFile("matrix.txt");

            long startTime = System.nanoTime();
            sparseMatrixArr1.solveA1();
            long endTime = System.nanoTime();
            timesArr1[round] = (endTime - startTime);

            MySparseMatrix sparseMatrixArr2 = new MySparseMatrixArray("matrix.txt");

            startTime = System.nanoTime();
            sparseMatrixArr2.solveA1();
            endTime = System.nanoTime();
            timesArr2[round] = (endTime - startTime);


            MySparseMatrix sparseMatrixHash1 = new MySparseMatrixHashMap("matrix.txt");

            startTime = System.nanoTime();
            sparseMatrixHash1.solveA1();
            endTime = System.nanoTime();
            timesHash1[round] = (endTime - startTime);

            MySparseMatrix sparseMatrixHash2 = new MySparseMatrixHashMap("matrix.txt");
            startTime = System.nanoTime();
            sparseMatrixHash2.solveA2();
            endTime = System.nanoTime();
            timesHash2[round] = (endTime - startTime);

            GaussianElimination sparseMatrixEx = new GaussianElimination();
            sparseMatrixEx.loadFromFile("matrix.txt");

            startTime = System.nanoTime();
            sparseMatrixEx.lsolve(sparseMatrixEx.A, sparseMatrixEx.B);
            endTime = System.nanoTime();
            timesEx[round] = (endTime - startTime);

            currSize += step;
        }

        writeToFile("denseArrA1.txt", timesArr1);
        writeToFile("denseArrA2.txt", timesArr2);
        writeToFile("denseHashA1.txt", timesHash1);
        writeToFile("denseHashA2.txt", timesHash2);
        writeToFile("denseEx.txt", timesEx);

    }



}
