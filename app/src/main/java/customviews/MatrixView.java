package customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.example.sergey.matrixandroidtask.R;

import java.util.Stack;

/**
 * Created by Sergey on 10/18/2017.
 */

public class MatrixView extends RelativeLayout {
    private int mWidth;
    private int mHeight;
    private int itemDimension;
    private int[][] data;
    private Handler mHandler;
    public static int counter = 0;

    public MatrixView(Context context,final int[][] data) {
        super(context);
        View.inflate(context, R.layout.matrix_layout, this);
        this.data = data;
        mHandler = new Handler();

        this.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                MatrixView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                mHeight = MatrixView.this.getHeight();
                mWidth = MatrixView.this.getWidth();
                itemDimension = mWidth / data.length;
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        fillMatrixItems();
                    }
                });
                return false;
            }
        });
    }

    private void fillMatrixItems() {

        int cursor = 0;
        int counterToCenter;
        int center = data.length / 2;


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

        if (data.length % 2 == 1) {
            inflateItem(center, center);
        }
    }

    private void inflateItem(final int i, final int j) {
        counter++;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MatrixItem item = new MatrixItem(getContext());
                item.setMatrixItemText(String.valueOf(data[i][j]));
                LayoutParams params = new LayoutParams(itemDimension, itemDimension);
                int leftMargin = j * itemDimension;
                int topMargin = i * itemDimension;
                params.setMargins(leftMargin, topMargin, 0, 0);
                item.setLayoutParams(params);
                MatrixView.this.addView(item);
            }
        }, 2 * counter);
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
