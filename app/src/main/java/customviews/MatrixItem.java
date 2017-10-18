package customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sergey.matrixandroidtask.R;

/**
 * Created by Sergey on 10/18/2017.
 */

public class MatrixItem extends RelativeLayout {
    private TextView mTextView;

    public MatrixItem(Context context) {
        super(context);
        View.inflate(context, R.layout.matrix_item, this);
        mTextView = (TextView) findViewById(R.id.matrix_item_text_view);
    }

    public MatrixItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.matrix_item, this);
    }

    public void setMatrixItemText(String text) {
        mTextView.setText(text);
    }
}
