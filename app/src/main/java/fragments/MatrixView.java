package fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

import com.example.sergey.matrixandroidtask.R;

import helpers.MatrixHelper;

/**
 * Created by Sergey on 10/18/2017.
 */

public class MatrixView extends RelativeLayout {
    private int mHeight;
    private int mWidth;
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
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                counter++;
                inflateItem(i, j);
            }
        }
    }

    private void inflateItem(final int i, final int j) {
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
        }, 500 * counter);
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
