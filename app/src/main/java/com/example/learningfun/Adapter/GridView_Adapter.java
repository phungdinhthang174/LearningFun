package com.example.learningfun.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learningfun.Model.GridView1;
import com.example.learningfun.R;

import java.util.List;

public class GridView_Adapter extends BaseAdapter {
    private Context context;
    private List<GridView1> list;

    public GridView_Adapter(Context context, List<GridView1> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view  = inflater.inflate(R.layout.item_grid_main,null);

        ImageView imageView = view.findViewById(R.id.img_anh_grid);
        TextView textView = view.findViewById(R.id.tv_name_grid);

        //gan gtri
        GridView1 gridView1 = list.get(i);
        textView.setText(gridView1.getName());
        if (gridView1.getPhoto() == 0){
            imageView.setImageResource(R.drawable.math);
        } else if (gridView1.getPhoto() == 1){
            imageView.setImageResource(R.drawable.tv);
        }else if (gridView1.getPhoto() == 2) {
            imageView.setImageResource(R.drawable.ta);
        }else if (gridView1.getPhoto() == 3) {
            imageView.setImageResource(R.drawable.kh);
        }else if (gridView1.getPhoto() == 4) {
            imageView.setImageResource(R.drawable.dovui);
        }else if (gridView1.getPhoto() == 5) {
            imageView.setImageResource(R.drawable.outline_account_circle_black_48);
        }
        return view;
    }
}
