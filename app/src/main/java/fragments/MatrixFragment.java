package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.sergey.matrixandroidtask.R;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.R.id.list;

/**
 * Created by Sergey on 10/17/2017.
 */

public class MatrixFragment extends Fragment {

    private static final String MATRIX_SIZE_KEY = "matrixsize";
    private GridView mMatrix;
    private static int mSize;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_matrix, container, false);
        Bundle args = getArguments();
        if (args != null && args.containsKey(MATRIX_SIZE_KEY)) {
            // TODO : Extract matrix size here
            mSize = args.getInt(MATRIX_SIZE_KEY);
        }
        mMatrix = inflatedView.findViewById(R.id.matrix_grid_view);
        mMatrix = inflatedView.findViewById(R.id.matrix_grid_view);
        ArrayList<Integer> list = new ArrayList<>();
        mMatrix.setNumColumns(mSize);
        for (int i = 0; i < mSize; i++) {
            for(int j = 0;j < mSize;j++) {
                list.add(Integer.valueOf(String.valueOf(i)+String.valueOf(j)));
            }
        }
        MatrixGridViewAdapter adapter = new MatrixGridViewAdapter(getActivity(), list);
        mMatrix.setAdapter(adapter);
        return inflatedView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
