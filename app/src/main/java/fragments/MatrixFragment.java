package fragments;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_matrix, container, false);
        Log.d(TAG, "Matrix Fragment is inflated");
        final NestedScrollView layoutContainer = (NestedScrollView) inflatedView.findViewById(R.id.main_container);
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

        // Here is the source of the bug in the app. If we don't remove callbacks from handler
        // it will be creating views in background, even if we leave the screen.
        // The obvious solution is to remove all pended tasks in a handler. But it doesn't work, and I do
        // not know why. Yes, tasks are removed from the handler, and it doesn't do anything when we leave
        // matrix screen, but when we return to it (for example swap input and matrix fragment) the handler
        // doesn't display a new matrix. I can't even imagine, why does it work in this way, because
        // we've destroyed the fragment, and re-initialized new handler, so it shouldn't depend on the
        // state of a previous handler. But it does
//        mMatrixView.removeCallbacks();
    }


}
