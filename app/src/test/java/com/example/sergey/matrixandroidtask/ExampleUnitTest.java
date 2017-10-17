package com.example.sergey.matrixandroidtask;

import org.junit.Assert;
import org.junit.Test;

import helpers.MatrixHelper;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testMatrixInCaseWith1x1Size() {

        int[][] expected = new int[1][1];
        expected[0][0] = 1;

        int[][] actual = MatrixHelper.generateMatrix(1);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMatrixInCase2x2Size() {
        int[][] expected = new int[][]{
                {4, 1},
                {3, 2}
        };

        int[][] actual = MatrixHelper.generateMatrix(2);
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void testMatrixInCase3x3Size() {
        int[][] expected = new int[][]{
                {10, 2, 3},
                {9, 1, 4},
                {8, 7, 5}
        };

        int[][] actual = MatrixHelper.generateMatrix(3);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMatrixInCase4x4Size() {
        int[][] expected = new int[][]{
                {18, 5, 7, 8},
                {17, 4, 1, 9},
                {15, 3, 2, 10},
                {14, 13, 12 ,11}
        };

        int[][] actual = MatrixHelper.generateMatrix(4);
        Assert.assertArrayEquals(expected, actual);
    }
}