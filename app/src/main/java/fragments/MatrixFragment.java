package fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.example.sergey.matrixandroidtask.R;

import helpers.MatrixHelper;

/**
 * Created by Sergey on 10/17/2017.
 */

public class MatrixFragment extends Fragment {

    private static final String TAG = "MatrixFragment";
    private static final String MATRIX_SIZE_KEY = "matrixsize";
    private static final String DELAY_KEY = "delay";
    private static int mDelay;
    private static int mMatrixSize;
    private GridLayout mGridLayout;
    private Handler mHandler = new Handler();
    private static int[][] mData;

    //end test
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_matrix, container, false);
//        mGridLayout = inflatedView.findViewById(R.id.matrix_grid_layout);

        LinearLayout layoutContainer = inflatedView.findViewById(R.id.main_container);
        MatrixView view = new MatrixView(getContext(), MatrixHelper.generateMatrix(200));

        layoutContainer.addView(view);


/*
        Bundle args = getArguments();

        if (args != null && args.containsKey(MATRIX_SIZE_KEY)) {
            mMatrixSize = args.getInt(MATRIX_SIZE_KEY);
            mDelay = args.getInt(DELAY_KEY);
            mData = MatrixHelper.generateMatrix(mMatrixSize);
        }
        mGridLayout.setRowCount(mMatrixSize);
        mGridLayout.setColumnCount(mMatrixSize);

        for (int i = 0; i < mMatrixSize; i++) {
            for (int j = 0; j < mMatrixSize; j++) {
                addButton(i, j);
            }
        }*/
        return inflatedView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
    }

    /*private void addButton(final int i, final int j) {
        int element = mData[i][j];
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Button btn = new Button(getContext());
                String text = String.valueOf(mData[i][j]);
                btn.setText(text);
                GridLayout.Spec rowSpan = GridLayout.spec(i, 1, 1); //i
                GridLayout.Spec columnSpan = GridLayout.spec(j, 1, 1); //j
                GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpan, columnSpan);
                //TODO : remove deprecated methods
                btn.setBackgroundColor(getResources().getColor(android.R.color.white));
                btn.setBackground(getResources().getDrawable(R.drawable.my_button));
                btn.setLayoutParams(params);
                mGridLayout.addView(btn);
            }
        }, element * mDelay);
    }*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
