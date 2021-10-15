package com.example.mywx;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TonXunAdapter extends BaseAdapter implements SectionIndexer {
    Context context;
    List<TonXunLu> tongXunList;
    public  void log(Object a){
        Log.d("找bug", a+"");
    }
    public TonXunAdapter(Context context, List<TonXunLu> tongXunList) {
        this.context = context;
        this.tongXunList = tongXunList;
    }

    @Override
    public int getCount() {
        return tongXunList.size();
    }

    @Override
    public Object getItem(int position) {
        return tongXunList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        convertView  = LayoutInflater.from(context).inflate(R.layout.tonx_xun,null);
        holder = new ViewHolder();
        holder.showLetter = convertView.findViewById(R.id.show_letter);
        holder.username = convertView.findViewById(R.id.username);
        holder.imageView = convertView.findViewById(R.id.ton_xum_img);
        TonXunLu tonXunLu = tongXunList.get(position);
        holder.username.setText(tonXunLu.getName());
        holder.imageView.setImageResource(tonXunLu.getImg());
        //获得分组
        int sectionForPosition = getSectionForPosition(position);
        //获得该分组第一项的position
        int positionForSection = getPositionForSection(sectionForPosition);
        //查看当前position是不是当前item所在分组的第一个item
        //如果是，则显示showLetter，否则隐藏
        if (position == positionForSection) {
            holder.showLetter.setVisibility(View.VISIBLE);
            holder.showLetter.setText(tonXunLu.getFirstLetter());
            holder.showLetter.setBackgroundColor(Color.parseColor("#CDEEEBEB"));
        } else {
            holder.showLetter.setVisibility(View.GONE);
        }
        return convertView;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    //创建分组
    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i = 0; i < tongXunList.size(); i++) {
            if (tongXunList.get(i).getFirstLetter().charAt(0) == sectionIndex) {
                return i;
            }
        }
        return -1;
    }

    //获得分组
    @Override
    public int getSectionForPosition(int position) {
        return tongXunList.get(position).getFirstLetter().charAt(0);
    }

    class ViewHolder{
            TextView username,showLetter;
            ImageView imageView;
    }
}
