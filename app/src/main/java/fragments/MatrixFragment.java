package fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergey.matrixandroidtask.R;

import customviews.MatrixView;
import model.WeirdMatrix;

/**
 * Created by Sergey on 10/17/2017.
 */

public class MatrixFragment extends Fragment {

    private static final String TAG = "MatrixFragment";
    private static final String MATRIX_SIZE_KEY = "matrixsize";
    private static final String DELAY_KEY = "delay";
    private static int mDelay;
    private static int mMatrixSize;
    private WeirdMatrix mMatrix;
    private MatrixView mMatrixView;
    private NestedScrollView layoutContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_matrix, container, false);
        Log.d(TAG, "Matrix Fragment is inflated");
        layoutContainer = (NestedScrollView) inflatedView.findViewById(R.id.main_container);
        Bundle args = getArguments();

        // Get args for generating matrix
        if (args != null && args.containsKey(MATRIX_SIZE_KEY)) {
            mMatrixSize = args.getInt(MATRIX_SIZE_KEY);
            mDelay = args.getInt(DELAY_KEY);
            mMatrix = new WeirdMatrix(mMatrixSize);
        }


        // Add our matrix to the container
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                mMatrixView = new MatrixView(getContext(), mMatrix, mDelay);
                layoutContainer.addView(mMatrixView);
            }
        });

        return inflatedView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Matrix Fragment is created");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMatrixView != null) {
            mMatrixView.removeCallbacks();
        }
    }


}
