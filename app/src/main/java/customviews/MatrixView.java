package customviews;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.example.sergey.matrixandroidtask.R;

import java.util.Stack;

import static android.content.ContentValues.TAG;

/**
 * Created by Sergey on 10/18/2017.
 */

public class MatrixView extends RelativeLayout {
    private int mWidth;
    private int mHeight;
    private int itemDimension = 250;
    private int[][] data;
    private static final String TAG = "MatrixView";
    private Handler mHandler;
    public static int counter = 0;
    private int mDelay;
    /*private ProgressDialog mProgressDialog;*/

    public MatrixView(Context context, final int[][] data, int delay) {
        super(context);
        View.inflate(context, R.layout.matrix_layout, this);
        this.data = data;
        mHandler = new Handler();
        mDelay = delay;

        /*mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("Just a moment");*/

        //TODO : Weird delay bug is here
        /*this.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                MatrixView.this.getViewTreeObserver().removeOnPreDrawListener(this);

                return false;
            }
        });*/
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
        int center = data.length / 2;
        Log.d(TAG, "fillMatrixItem has started");
        for (counterToCenter = 1; counterToCenter <= center; counterToCenter++) {

            for (cursor = counterToCenter - 1; cursor < data.length - counterToCenter + 1; cursor++) {
                inflateItem(cursor, counterToCenter - 1);
            }

            for (cursor = counterToCenter; cursor < data.length - counterToCenter + 1; cursor++) {
                inflateItem(data.length - counterToCenter, cursor);
            }

            for (cursor = data.length - counterToCenter - 1; cursor >= counterToCenter; cursor--) {
                inflateItem(cursor, data.length - counterToCenter);
            }

            for (cursor = data.length - counterToCenter; cursor >= counterToCenter; cursor--) {
                inflateItem(counterToCenter - 1, cursor);
            }

        }
        Log.d(TAG, "fillMatrixItem has finished");
        if (data.length % 2 == 1) {
            inflateItem(center, center);
        }
    }

    private void inflateItem(final int i, final int j) {
        counter++;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "inflate has finished");
                MatrixItem item = new MatrixItem(getContext());
                item.setMatrixItemText(String.valueOf(data[i][j]));
                LayoutParams params = new LayoutParams(itemDimension, itemDimension);
                int leftMargin = j * itemDimension;
                int topMargin = i * itemDimension;
                params.setMargins(leftMargin, topMargin, 0, 0);
                item.setLayoutParams(params);
                MatrixView.this.addView(item);
                requestLayout();
                Log.d(TAG, "inflateItem has finished");
            }
        }, mDelay * counter);

    }


    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.matrix_layout, this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
