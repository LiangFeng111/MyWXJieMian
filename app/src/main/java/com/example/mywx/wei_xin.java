package com.example.mywx;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class wei_xin extends Fragment {
    List<people> list;
    ListView listView;
    View views;
    MyAdapter myAdapter;
    SwipeRefreshLayout lin_yout;

    Main main;

    Random random = new Random();
    List<people> list_update=new ArrayList<>();
    public  void log(Object a){
        Log.d("显示", a+"");
    }
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wen_xin,container,false);
        listView = view.findViewById(R.id.listView);
        this.views = view;
        main = new Main();
        init();
        registerForContextMenu(listView);

        //刷新数据
        lin_yout  = view.findViewById(R.id.SwLayout);
        lin_yout.setColorSchemeResources(R.color.design_default_color_primary);
        lin_yout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                update();
                lin_yout.setRefreshing(false);
            }
        });
        return view;
    }


    //上下文菜单
    @Override
    public void onCreateContextMenu( ContextMenu menu,  View v,  ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "标为未读");
        menu.add(0, 2, 0, "置顶该聊天");
        menu.add(0, 0, 0, "不显示该聊天");
        menu.add(0, 1, 0, "删除该聊天");
    }

    //上下文菜单点击事件
    @Override
    public boolean onContextItemSelected( MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case 0:
                Toast.makeText(views.getContext(),"当前点击了"+list_update.get(menuInfo.position).getName(),Toast.LENGTH_SHORT).show();
                break;
            case 1:
                //适配器里面创建
                myAdapter.remover(menuInfo.position);
                break;
            case 2:
                Toast.makeText(views.getContext(),"当前点击了"+list_update.get(menuInfo.position).getName2(),Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }


    //总数据
    public void init(){
        list = new ArrayList<people>();
        for (int i = 0; i < 30; i++) {
            int n =random.nextInt(12);
            if (i%2==0){
                list.add(new people("风",R.drawable.tou_xiang1,"阿巴阿巴",n+":00"));
            }else {
                list.add(new people("晴天",R.drawable.tou_xiang2,"又是天晴",n+":00"));
            }
        }
        update();
    }

    //随机添加数据
    public void update(){
        list_update.clear();
        random();
        myAdapter = new MyAdapter(views.getContext(),list_update);
        listView.setAdapter(myAdapter);
    }

    //随机添加
    public  void random(){
        for (int i = 0; i < 30; i++) {
            int n = random.nextInt(list.size());
            list_update.add(list.get(n));
        }
    }

}
