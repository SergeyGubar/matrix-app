package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sergey.matrixandroidtask.R;

/**
 * Created by Sergey on 10/18/2017.
 */

public class MatrixRecyclerAdapter extends RecyclerView.Adapter<MatrixRecyclerAdapter.MyViewHolder> {

    private TextView mTextView;
    private LayoutInflater mInflater;


    private int[][] mData = new int[0][];
    private int matrixLength = 0;


    public  MatrixRecyclerAdapter(Context ctx, int[][] data) {
        mInflater = LayoutInflater.from(ctx);
        mData = data;
        matrixLength = data.length;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        int rowIndex = position / matrixLength;
        int columnIndex = position % matrixLength;
        holder.updateUi(String.valueOf(position));
//        mData[rowIndex][columnIndex]
    }

    @Override
    public int getItemCount() {
        return mData.length * mData.length;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.number_text_view);
        }
        public void updateUi(String text) {
            mTextView.setText(text);
        }

    }
}
