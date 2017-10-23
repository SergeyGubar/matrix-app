package com.example.sergey.matrixandroidtask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import fragments.InputFragment;
import fragments.MatrixFragment;
import interfaces.MainActivityApi;

public class MainActivity extends AppCompatActivity implements MainActivityApi {

    private static final String MATRIX_SIZE_KEY = "matrixsize";
    private static final String DELAY_KEY = "delay";
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = new InputFragment();
        mFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void startMatrixFragment(int size, int delay) {
        Fragment fragment = new MatrixFragment();
        Bundle args = new Bundle();
        args.putInt(MATRIX_SIZE_KEY, size);
        args.putInt(DELAY_KEY, delay);
        fragment.setArguments(args);
        mFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.remove_matrix:
                mFragmentManager.beginTransaction().replace(R.id.fragment_container, new InputFragment()).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
