package customviews;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.sergey.matrixandroidtask.R;

import model.WeirdMatrix;

/**
 * Created by Sergey on 10/18/2017.
 */

public class MatrixView extends RelativeLayout {
    private int itemDimension = 250;
    private WeirdMatrix mMatrix;
    private static final String TAG = "MatrixView";
    private Handler mHandler;
    public static int mCounter;
    private int mDelay;

    public MatrixView(Context context, WeirdMatrix data, int delay) {
        super(context);
        View.inflate(context, R.layout.matrix_layout, this);
        this.mMatrix = data;
        mDelay = delay;
        mCounter = 0;
        mHandler = new Handler();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                fillMatrixItems();
            }
        });
    }

    private void fillMatrixItems() {

        int cursor = 0;
        int counterToCenter;
        int center = mMatrix.getData().length / 2;

        // This loop looks a little bit scary, but the purpose is simple - to fill 2d array (matrix)
        // In the right (spiral) order

        Log.d(TAG, String.valueOf(center));
        for (counterToCenter = 1; counterToCenter <= center; counterToCenter++) {

            // This loop iterates to the bottom edge
            for (cursor = counterToCenter - 1; cursor < mMatrix.getData().length - counterToCenter + 1; cursor++) {
                inflateItem(cursor, counterToCenter - 1);
            }
            // This loop iterates to the right edge
            for (cursor = counterToCenter; cursor < mMatrix.getData().length - counterToCenter + 1; cursor++) {
                inflateItem(mMatrix.getData().length - counterToCenter, cursor);
            }
            // To the top edge
            for (cursor = mMatrix.getData().length - counterToCenter - 1; cursor >= counterToCenter; cursor--) {
                inflateItem(cursor, mMatrix.getData().length - counterToCenter);
            }
            // To the left edge
            for (cursor = mMatrix.getData().length - counterToCenter; cursor >= counterToCenter; cursor--) {
                inflateItem(counterToCenter - 1, cursor);
            }

            // And again, starting from the top edge
        }
        Log.d(TAG, "fillMatrix has finished");
        if (mMatrix.getData().length % 2 == 1) {
            inflateItem(center, center);
        }
    }

    private void inflateItem(final int i, final int j) {
        mCounter++;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "inflate has started");
                MatrixItem item = new MatrixItem(getContext());
                item.setAlpha(0.0f);
                item.animate()
                        .translationY(item.getHeight())
                        .alpha(1.0f)
                        .setListener(null);
                item.setMatrixItemText(String.valueOf(mMatrix.getData()[i][j]));
                LayoutParams params = new LayoutParams(itemDimension, itemDimension);
                int leftMargin = j * itemDimension;
                int topMargin = i * itemDimension;
                params.setMargins(leftMargin, topMargin, 0, 0);
                item.setLayoutParams(params);
                MatrixView.this.addView(item);
                requestLayout();
                Log.d(TAG, "inflateItem has finished");
            }
        }, mDelay * mCounter);

    }


    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.matrix_layout, this);
    }

    public void removeCallbacks() {
        mHandler.removeCallbacksAndMessages(null);
    }



}
