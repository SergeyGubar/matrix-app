package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergey.matrixandroidtask.R;

import adapters.FixedGridLayoutManager;
import adapters.MatrixRecyclerAdapter;
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
    private SpiralMatrix mMatrix;
    private static int mMatrixDimension;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_matrix, container, false);

        Bundle args = getArguments();

        // Get those variables we need from the inputFragment

        if (args != null && args.containsKey(MATRIX_SIZE_KEY)) {
            mMatrixDimension = args.getInt(MATRIX_SIZE_KEY);
            mMatrix = new SpiralMatrix(mMatrixDimension);
            mDelay = args.getInt(DELAY_KEY);
        }

        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.recycler_view);
        mAdapter = new MatrixRecyclerAdapter(getContext(), mMatrix.getMatrix());


        FixedGridLayoutManager manager = new FixedGridLayoutManager();
        manager.setTotalColumnCount(mMatrixDimension);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(manager);

        return inflatedView;
    }





}
