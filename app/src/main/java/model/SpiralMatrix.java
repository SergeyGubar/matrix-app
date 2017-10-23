package model;

import java.util.Stack;

import helpers.MatrixHelper;

/**
 * Created by Sergey on 10/18/2017.
 */

public class SpiralMatrix {

    private int[][] mData;

    public SpiralMatrix(int size) {
        mData = MatrixHelper.generateMatrix(size);
    }


    public int[][] getMatrix() {
        return mData;
    }

    public int getDimension() {
        return mData.length;
    }
}
