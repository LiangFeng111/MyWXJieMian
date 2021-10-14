package com.example.mywx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<people> list;

    public MyAdapter(Context context, List<people> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView  = LayoutInflater.from(context).inflate(R.layout.fruit_item,null);
        CircleImageView imageView= convertView.findViewById(R.id.fruit_image);
        TextView txt = convertView.findViewById(R.id.fruit_text);
        TextView txt1 = convertView.findViewById(R.id.fruit_text2);
        TextView time = convertView.findViewById(R.id.time_);
        people fruit = list.get(position);
        imageView.setImageResource(fruit.getImage());
        txt.setText(fruit.getName());
        txt1.setText(fruit.getName2());
        time.setText(fruit.getTime());
        return convertView;
    }

    public void remover(int position){
        //删除list的其中一行
        list.remove(position);
        //更新数据
        notifyDataSetChanged();
    }
}
