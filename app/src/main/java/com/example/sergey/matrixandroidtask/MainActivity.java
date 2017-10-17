package com.example.sergey.matrixandroidtask;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragments.InputFragment;
import fragments.MatrixFragment;
import interfaces.MainActivityApi;

public class MainActivity extends AppCompatActivity implements MainActivityApi {

    private static final String MATRIX_SIZE_KEY = "matrixsize";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new InputFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void startMatrixFragment(int size) {
        Fragment fragment = new MatrixFragment();
        Bundle args = new Bundle();
        args.putInt(MATRIX_SIZE_KEY, size);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
