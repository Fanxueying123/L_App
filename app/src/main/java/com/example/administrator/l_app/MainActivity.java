package com.example.administrator.l_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.l_app.Ul.fragment.CircleFragment;
import com.example.administrator.l_app.Ul.fragment.FindFragment;
import com.example.administrator.l_app.Ul.fragment.MeFragment;
import com.example.administrator.l_app.Ul.fragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private BottomNavigationBar mbottomNavigationBar;
    private List<Fragment> mfragments;//定义Fragments数组
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        init();//数据初始化
    }

    private void init() {
        //初始化Fragments数组
        mfragments=new ArrayList<>();
        mfragments.add(new CircleFragment());
        mfragments.add(new FindFragment());
        mfragments.add(new MessageFragment());
        mfragments.add(new MeFragment());
        //加载底部导航布局文件（数据初始化）
        mbottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_circle_selector,"动态"))
                .addItem(new BottomNavigationItem(R.drawable.nav_find_selector,"发现"))
                .addItem(new BottomNavigationItem(R.drawable.nav_message_selector,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector,"我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();
        mbottomNavigationBar.setTabSelectedListener(this);
        setFragment(0);//设置默认状态
    }

    private void setFragment(int position) {//加载，添加Fragment文件
        FragmentManager fm=this.getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_container,mfragments.get(position));
        ft.commit();
    }

    private void initview() {
        mbottomNavigationBar=(BottomNavigationBar)findViewById(R.id.btn_navgation_bar);
    }

    @Override
    public void onTabSelected(int position) {
        //加载，添加Fragment文件
        setFragment(position);

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
