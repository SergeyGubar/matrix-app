package fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergey.matrixandroidtask.R;

import helpers.MatrixHelper;
import model.WeirdMatrix;

/**
 * Created by Sergey on 10/17/2017.
 */

public class MatrixFragment extends Fragment {

    private static final String MATRIX_SIZE_KEY = "matrixsize";
    private static int mCellsNumber;
    private LinearLayout mViewGroup;
    private static int mCellsAdded;
    private Handler mHandler = new Handler();
    private WeirdMatrix mMatrix;
    private static final String TAG = "MatrixFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_matrix, container, false);
        mViewGroup = inflatedView.findViewById(R.id.main_container);
        Bundle args = getArguments();
        if (args != null && args.containsKey(MATRIX_SIZE_KEY)) {
            int matrixSize = args.getInt(MATRIX_SIZE_KEY);
            mCellsNumber = (int) Math.pow(matrixSize, 2);
            mMatrix = new WeirdMatrix(matrixSize);
            inflateMatrix();
        }
        return inflatedView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
    }

    //TODO : Improve View
    private void inflateMatrix() {
        if (mCellsAdded < mCellsNumber) {
            mCellsAdded++;
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TextView textView = new TextView(getContext());
                    //TODO : Value animator, setalpha
                    String itemText = String.valueOf(mMatrix.getNextItem());
                    textView.setText(itemText);
                    mViewGroup.addView(textView, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    inflateMatrix();
                }
            }, 500);
        }
    }
}
