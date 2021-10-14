package com.example.mywx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SwitchCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity implements View.OnClickListener {

    ImageView wei_xin_clc,lian_xi_clc,fa_xian_clc,wo_clc;
    LinearLayout toolbarlayout;
    //创建碎片
    wei_xin wei_xinFm;
    Tong_xun tong_xunFm;
    FaXiang faXiangFm;
    Wo_de wo_deFm;
    //页面滑动
    ViewPager viewPager;
    List<Fragment> fragmentList = new ArrayList<>();
    FragAdapter fragAdapter ;
    public  void log(Object a){
        Log.d("显示", a+"");
    }

    TextView txt1,txt2,txt3,txt4;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.wei_xin_main);
        entity();
        viewPager = findViewById(R.id.viewpager);
        fragAdapter = new FragAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setOffscreenPageLimit(4);//ViewPager的缓存为4帧
        viewPager.setAdapter(fragAdapter);
        viewPager.setCurrentItem(0);//初始设置ViewPager选中第一帧
        wei_xin_clc.setColorFilter(Color.parseColor("#ED12FF00"));
        txt1.setTextColor(Color.parseColor("#ED12FF00"));
        //viewpager的事件
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //滑动事件
            @Override
            public void onPageSelected(int position) {
                changeTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



    //底部变色，一些效果
    private void changeTextColor(int position) {
        if (position==0){
            setTitle("微信");
            toolbarlayout.setVisibility(View.VISIBLE);
            wei_xin_clc.setColorFilter(Color.parseColor("#ED12FF00"));
            lian_xi_clc.setColorFilter(Color.parseColor("#8E010101"));
            fa_xian_clc.setColorFilter(Color.parseColor("#8E010101"));
            wo_clc.setColorFilter(Color.parseColor("#8E010101"));
            txt1.setTextColor(Color.parseColor("#ED12FF00"));
            txt2.setTextColor(Color.parseColor("#8E010101"));
            txt3.setTextColor(Color.parseColor("#8E010101"));
            txt4.setTextColor(Color.parseColor("#8E010101"));
        }else if (position==1){
            setTitle("联系人");
            wei_xin_clc.setColorFilter(Color.parseColor("#8E010101"));
            lian_xi_clc.setColorFilter(Color.parseColor("#ED12FF00"));
            fa_xian_clc.setColorFilter(Color.parseColor("#8E010101"));
            wo_clc.setColorFilter(Color.parseColor("#8E010101"));
            txt1.setTextColor(Color.parseColor("#8E010101"));
            txt2.setTextColor(Color.parseColor("#ED12FF00"));
            txt3.setTextColor(Color.parseColor("#8E010101"));
            txt4.setTextColor(Color.parseColor("#8E010101"));
        }else if (position==2){
            setTitle("发现");
            wei_xin_clc.setColorFilter(Color.parseColor("#8E010101"));
            lian_xi_clc.setColorFilter(Color.parseColor("#8E010101"));
            fa_xian_clc.setColorFilter(Color.parseColor("#ED12FF00"));
            wo_clc.setColorFilter(Color.parseColor("#8E010101"));
            txt1.setTextColor(Color.parseColor("#8E010101"));
            txt2.setTextColor(Color.parseColor("#8E010101"));
            txt3.setTextColor(Color.parseColor("#ED12FF00"));
            txt4.setTextColor(Color.parseColor("#8E010101"));
        }else if (position==3){
            setTitle("我");
            wei_xin_clc.setColorFilter(Color.parseColor("#8E010101"));
            lian_xi_clc.setColorFilter(Color.parseColor("#8E010101"));
            fa_xian_clc.setColorFilter(Color.parseColor("#8E010101"));
            wo_clc.setColorFilter(Color.parseColor("#ED12FF00"));
            txt1.setTextColor(Color.parseColor("#8E010101"));
            txt2.setTextColor(Color.parseColor("#8E010101"));
            txt3.setTextColor(Color.parseColor("#8E010101"));
            txt4.setTextColor(Color.parseColor("#ED12FF00"));
        }
    }
    //菜单栏
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return true;
    }

    public  void entity(){

        //四个碎片
        wei_xinFm = new wei_xin();
        tong_xunFm = new Tong_xun();
        faXiangFm = new FaXiang();
        wo_deFm = new Wo_de();


        //添加进去
        fragmentList.add(wei_xinFm);
        fragmentList.add(tong_xunFm);
        fragmentList.add(faXiangFm);
        fragmentList.add(wo_deFm);

        txt1 =findViewById(R.id.di_txt1);
        txt2 =findViewById(R.id.di_txt2);
        txt3 =findViewById(R.id.di_txt3);
        txt4 =findViewById(R.id.di_txt4);

        wei_xin_clc = findViewById(R.id.wei_xin_clc);
        lian_xi_clc = findViewById(R.id.lian_xi_clc);
        fa_xian_clc = findViewById(R.id.fa_xian_clc);
        wo_clc = findViewById(R.id.wo_clc);

        toolbarlayout = findViewById(R.id.toolbarlayout);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pen_you_id:
                Toast.makeText(this,"您点击了朋友圈",Toast.LENGTH_SHORT).show();
                break;
            case R.id.shi_ping_id:
                Toast.makeText(this,"您点击了视频号",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sao_yi_sao_id:
                Toast.makeText(this,"您点击了扫一扫",Toast.LENGTH_SHORT).show();
                break;
            case R.id.di_wei_xin:
                viewPager.setCurrentItem(0);
                break;
            case R.id.di_lian_xi:
                viewPager.setCurrentItem(1);
                break;
            case R.id.di_fa_xian:
                viewPager.setCurrentItem(2);
                break;
            case R.id.di_wo:
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

}
