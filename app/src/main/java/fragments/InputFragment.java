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
import android.widget.Toast;

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
                String text = mMatrixSizeEditText.getText().toString();
                int matrixSize;
                // Validation
                try {
                    matrixSize = Integer.parseInt(text);
                    if(matrixSize < 1 || matrixSize > 1000) {
                        Toast.makeText(getContext(), "Number is not in range 0 < n < 1000", Toast.LENGTH_SHORT).show();
                    } else {
                        mActivityApi.startMatrixFragment(matrixSize);
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    Toast.makeText(getContext(), "Bad formatted number!", Toast.LENGTH_SHORT).show();
                }

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
