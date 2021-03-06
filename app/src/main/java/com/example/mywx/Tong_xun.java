package com.example.mywx;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Tong_xun extends Fragment {

    List<TonXunLu> list = new ArrayList<>();
    ListView listView ;
    TextView textView ,show_letter;
    Context context;
    View view;
    public void log(String a,Object b){
        Log.i(a, b+"");
    }
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ton_xun,container,false);
        context = inflater.getContext();
        init();
        textView = view.findViewById(R.id.show_letter_in_center);
        listView = view.findViewById(R.id.ton_xun_listview);
        TonXunAdapter adapter = new TonXunAdapter(view.getContext(),list);
        final LetterIndexView letterIndexView = view.findViewById(R.id.letter_index_view);
        letterIndexView.setTextViewDialog(textView);
        letterIndexView.setUpdateListView(new LetterIndexView.UpdateListView() {
            @Override
            public void updateListView(String letter) {
                int positionForSection = adapter.getPositionForSection(letter.charAt(0));
                listView.setSelection(positionForSection);
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int sectionForPosition = adapter.getSectionForPosition(firstVisibleItem);
                letterIndexView.updateLetterIndexView(sectionForPosition);
            }
        });

        listView.setAdapter(adapter);
        return view;
    }



    public  void init(){
        list.add(new TonXunLu("????????????",R.drawable.tian_jia_hao_you,"A"));
        list.add(new TonXunLu("??????",R.drawable.qun_liao,"A"));
        list.add(new TonXunLu("??????",R.drawable.baio_qian,"A"));
        list.add(new TonXunLu("?????????",R.drawable.gom_zhong_hao,"A"));
        list.add(new TonXunLu("??????",R.drawable.tou_xiang1,"L"));
        list.add(new TonXunLu("??????",R.drawable.tou_xiang1,"L"));
        list.add(new TonXunLu("??????",R.drawable.tou_xiang1,"L"));
        list.add(new TonXunLu("??????",R.drawable.tou_xiang1,"L"));
        list.add(new TonXunLu("??????",R.drawable.tou_xiang1,"L"));
        list.add(new TonXunLu("??????????????????",R.drawable.tou_xiang1,"K"));
        list.add(new TonXunLu("??????????????????",R.drawable.tou_xiang1,"K"));
        list.add(new TonXunLu("??????????????????",R.drawable.tou_xiang1,"K"));
        list.add(new TonXunLu("??????????????????",R.drawable.tou_xiang1,"K"));
        list.add(new TonXunLu("??????????????????",R.drawable.tou_xiang1,"F"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"F"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"F"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"F"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"X"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"X"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"X"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"X"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"X"));
        list.add(new TonXunLu("??????????????????",R.drawable.tou_xiang1,"X"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"G"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"G"));
        list.add(new TonXunLu("????????????",R.drawable.tou_xiang1,"G"));
        list.add(new TonXunLu("???????????????",R.drawable.tou_xiang1,"N"));
        list.add(new TonXunLu("???????????????",R.drawable.tou_xiang1,"N"));
        list.add(new TonXunLu("???????????????",R.drawable.tou_xiang1,"N"));
        list.add(new TonXunLu("???????????????",R.drawable.tou_xiang1,"N"));
    }


}
