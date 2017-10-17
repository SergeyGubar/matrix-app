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
                {1, 4},
                {2, 3}
        };

        int[][] actual = MatrixHelper.generateMatrix(2);
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void testMatrixInCase3x3Size() {
        int[][] expected = new int[][]{
                {1, 9, 8},
                {2, 10, 7},
                {3, 4, 5}
        };

        int[][] actual = MatrixHelper.generateMatrix(3);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMatrixInCase4x4Size() {
        int[][] expected = new int[][]{
                {1, 13, 12, 11},
                {2, 14, 18, 10},
                {3, 15, 17, 9},
                {4, 5, 7 ,8}
        };

        int[][] actual = MatrixHelper.generateMatrix(4);
        Assert.assertArrayEquals(expected, actual);
    }
}