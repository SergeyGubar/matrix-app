package fragments;

import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.CellIdentityCdma;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.sergey.matrixandroidtask.R;

import adapters.FixedGridLayoutManager;
import adapters.MatrixRecyclerAdapter;
import customviews.MatrixView;
import helpers.MatrixHelper;
import model.SpiralMatrix;

/**
 * Created by Sergey on 10/17/2017.
 */

public class MatrixFragment extends Fragment {

    private static final String TAG = "MatrixFragment";
    private static final String MATRIX_SIZE_KEY = "matrixsize";
    private static final String DELAY_KEY = "delay";
    private static int mDelay;
    private RecyclerView mRecyclerView;
    private MatrixRecyclerAdapter mAdapter;
    public static int mCellSize = 200;
    private SpiralMatrix mMatrix;
    private static int mMatrixDimension;


    //end test
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_matrix, container, false);

        Bundle args = getArguments();

        if (args != null && args.containsKey(MATRIX_SIZE_KEY)) {
            mMatrixDimension = args.getInt(MATRIX_SIZE_KEY);
            mMatrix = new SpiralMatrix(mMatrixDimension);
            mDelay = args.getInt(DELAY_KEY);
        }

        RelativeLayout rl = (RelativeLayout) inflatedView.findViewById(R.id.main_container);
        int[][] arr = mMatrix.getMatrix();
        MatrixView view = new MatrixView(getContext(), arr);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(mCellSize * arr.length, mCellSize * arr.length);
        view.setLayoutParams(params);
        rl.addView(view);
/*

        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.matrix_recycler_view);
        mAdapter = new MatrixRecyclerAdapter(getContext(), mMatrix.getMatrix());


        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), mMatrixDimension);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(manager);
*/

        return inflatedView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
