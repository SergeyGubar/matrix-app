package model;

import java.util.Stack;

import helpers.MatrixHelper;

/**
 * Created by Sergey on 10/18/2017.
 */

public class WeirdMatrix {
    private Stack<Integer> mData;

    public WeirdMatrix(int size) {
        mData = MatrixHelper.makeNumbersStack(size);
    }
    public int getNextItem() {
        return mData.pop();
    }
}
