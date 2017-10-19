package fragments;

import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.example.sergey.matrixandroidtask.R;

import customviews.MatrixView;
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
    private Handler mHandler = new Handler();
    private static int[][] mData;

    //end test
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_matrix, container, false);

        LinearLayout layoutContainer = inflatedView.findViewById(R.id.main_container);

        Bundle args = getArguments();

        if (args != null && args.containsKey(MATRIX_SIZE_KEY)) {
            mMatrixSize = args.getInt(MATRIX_SIZE_KEY);
            mDelay = args.getInt(DELAY_KEY);
            mData = MatrixHelper.generateMatrix(mMatrixSize);
        }

        MatrixView view = new MatrixView(getContext(), mData);

        layoutContainer.addView(view);

        return inflatedView;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }


}
