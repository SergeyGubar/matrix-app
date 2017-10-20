package customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Stack;

/**
 * Created by Sergey on 10/18/2017.
 */

public class MatrixView extends View {
    private Color mColor;
    private int cellSize = 200;
    private int[][] data;
    private Paint mPaint;

    public MatrixView(Context context, final int[][] data) {
        super(context);
        this.data = data;
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(1);
        mPaint.setTextSize(22);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }


    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                int x = i * cellSize;
                int y = j * cellSize;
                canvas.drawRect(x, y, x + cellSize, y + cellSize, mPaint);
                canvas.drawText(String.valueOf(data[i][j]), i * cellSize + cellSize / 4, j * cellSize + cellSize / 2, mPaint);
            }
        }

    }


}
