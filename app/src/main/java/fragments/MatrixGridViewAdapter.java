package fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.sergey.matrixandroidtask.R;

import java.util.ArrayList;

/**
 * Created by Sergey on 10/17/2017.
 */

public class MatrixGridViewAdapter extends BaseAdapter {
    ArrayList<Integer> items;

    static Activity mActivity;

    private static LayoutInflater inflater = null;

    public MatrixGridViewAdapter(Activity activity, ArrayList<Integer> data) {

        mActivity = activity;
        items = data;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public final int getCount() {
        return items.size();
    }

    @Override
    public final Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public final long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v;
        v = inflater.inflate(R.layout.matrix_item, null);
        //TODO : Remove that awful stuff
        v.setLayoutParams(new GridView.LayoutParams(200, 200));
        Button tv = v.findViewById(R.id.button);
        tv.setText(items.get(position).toString());

        return v;
    }
}