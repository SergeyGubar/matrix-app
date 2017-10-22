package adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergey.matrixandroidtask.R;

/**
 * Created by Sergey on 10/18/2017.
 */

public class MatrixRecyclerAdapter extends RecyclerView.Adapter<MatrixRecyclerAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private int[][] mData = new int[0][];


    public  MatrixRecyclerAdapter(Context ctx, int[][] data) {
        mInflater = LayoutInflater.from(ctx);
        mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        int rowIndex = position / mData.length;
        int columnIndex = position % mData.length;
        holder.updateUi(String.valueOf(String.valueOf(mData[rowIndex][columnIndex])));
    }

    @Override
    public int getItemCount() {
        return mData.length * mData.length;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.number_text_view);
        }
        public void updateUi(String text) {
            mTextView.setText(text);
        }

    }
}
