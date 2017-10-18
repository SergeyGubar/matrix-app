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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergey.matrixandroidtask.R;

import interfaces.MainActivityApi;

/**
 * Created by Sergey on 10/17/2017.
 */

public class InputFragment extends Fragment {
    private Button mStartMatrixFragmentButton;
    private EditText mMatrixSizeEditText;
    private TextView mDelayTextView;
    private SeekBar mDelaySeekBar;
    private MainActivityApi mActivityApi;
    private static final int SEEKBAR_MIN_VALUE = 100;
    private static final int SEEKBAR_MAX_VALUE = 1000;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_input, container, false);

        // View initialization
        mStartMatrixFragmentButton = inflatedView.findViewById(R.id.draw_matrix_button);
        mMatrixSizeEditText = inflatedView.findViewById(R.id.number_edit_text);
        mDelaySeekBar = inflatedView.findViewById(R.id.delay_seek_bar);
        mDelayTextView = inflatedView.findViewById(R.id.delay_text_view);

        mDelaySeekBar.setMax(SEEKBAR_MAX_VALUE - SEEKBAR_MIN_VALUE);
        mDelaySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = SEEKBAR_MIN_VALUE + progress;
                mDelayTextView.setText(String.valueOf(value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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
                        mActivityApi.startMatrixFragment(matrixSize, mDelaySeekBar.getProgress() + SEEKBAR_MIN_VALUE);
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
