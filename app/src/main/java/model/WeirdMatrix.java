package model;

import java.util.Stack;

import helpers.MatrixHelper;

/**
 * Created by Sergey on 10/18/2017.
 */

public class WeirdMatrix {
    private int[][] mData;
    public WeirdMatrix(int size) {
        mData = MatrixHelper.generateMatrix(size);
    }

    public int[][] getData() {
        return mData;
    }
}
