package fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sergey.matrixandroidtask.R;

import interfaces.MainActivityApi;

/**
 * Created by Sergey on 10/17/2017.
 */

public class InputFragment extends Fragment {
    private Button mStartMatrixFragmentButton;
    private EditText mMatrixSizeEditText;
    private MainActivityApi mActivityApi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_input, container, false);

        // View initialization
        mStartMatrixFragmentButton = inflatedView.findViewById(R.id.draw_matrix_button);
        mMatrixSizeEditText = inflatedView.findViewById(R.id.number_edit_text);

        // On button click - activity should replace this fragment by matrix fragment
        mStartMatrixFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : Remove dummy number + validation
                mActivityApi.startMatrixFragment(Integer.valueOf(mMatrixSizeEditText
                        .getText()
                        .toString()));
            }
        });
        return inflatedView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivityApi = (MainActivityApi) context;
    }
}
