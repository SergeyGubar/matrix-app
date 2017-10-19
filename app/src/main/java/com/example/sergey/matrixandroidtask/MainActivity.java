package com.example.sergey.matrixandroidtask;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import fragments.InputFragment;
import fragments.MatrixFragment;
import interfaces.MainActivityApi;

public class MainActivity extends AppCompatActivity implements MainActivityApi {

    private static final String MATRIX_SIZE_KEY = "matrixsize";
    private static final String DELAY_KEY = "delay";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // First of all, inflate Input fragment
        Fragment fragment = new InputFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void startMatrixFragment(int size, int delay) {

        // This is the callback for the InputFragment.
        // If the button here was clicked, we should place another fragment in the container
        Fragment fragment = new MatrixFragment();
        Bundle args = new Bundle();
        args.putInt(MATRIX_SIZE_KEY, size);
        args.putInt(DELAY_KEY, delay);
        fragment.setArguments(args);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset_fragment:
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                if(fragment != null) {
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                    Fragment newFragment = new InputFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, newFragment)
                            .commit();
                }
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
