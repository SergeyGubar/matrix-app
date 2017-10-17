package fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergey.matrixandroidtask.R;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.R.id.list;

/**
 * Created by Sergey on 10/17/2017.
 */

public class MatrixFragment extends Fragment {

    private static final String MATRIX_SIZE_KEY = "matrixsize";
    private static int mSize;
    private LinearLayout mViewGroup;
    private static int mViewsAdded;
    private Handler mHandler = new Handler();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_matrix, container, false);
        Bundle args = getArguments();
        if (args != null && args.containsKey(MATRIX_SIZE_KEY)) {
            mSize = args.getInt(MATRIX_SIZE_KEY);
        }

        mViewGroup = inflatedView.findViewById(R.id.main_container);

        addNewTextView();

        return inflatedView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
    }

    private void addNewTextView() {
        if (mViewsAdded < 5) {
            mViewsAdded++;
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TextView textView = new TextView(getContext());
                    textView.setText("test");
                    mViewGroup.addView(textView, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    addNewTextView();
                }
            }, 500);
        }
    }
}
