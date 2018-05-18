package com.example.administrator.l_app.Ul.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.l_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends Fragment {
    private TabLayout mtabLayout;
    private ViewPager mviewPager;
    private View mview;
    private List<Fragment>mfragment;

    public CircleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview= inflater.inflate(R.layout.fragment_circle, container, false);
        initView();
        init();
        return mview;
    }

    private void init() {
        //添加数据适配器
        mfragment=new ArrayList<>();
        mfragment.add(new NewFragment());
        mfragment.add(new VideoFragment());
        mfragment.add(new ImageFragment());
        //添加数据适配器
        PagerAdapter adapter=new PagerAdapter(getChildFragmentManager());
        mviewPager.setAdapter(adapter);
        //TabLayout与ViewPager连接起来（进行绑定）
        mtabLayout.setupWithViewPager(mviewPager);
        //显示具体的顶部标题
        mtabLayout.getTabAt(0).setText("新闻");
        mtabLayout.getTabAt(1).setText("图片");
        mtabLayout.getTabAt(2).setText("视频");

    }

    private void initView() {
        mtabLayout=(TabLayout)mview.findViewById(R.id.tab_pager);
        mviewPager=(ViewPager)mview.findViewById(R.id.view_pager);
    }
    /*private class PagerAdapter extends FragmentPagerAdapter*/
    //建立数据适配器MyFragmentPagerAdapter重写其构造方法
    private class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mfragment.get(position);
        }

        @Override
        public int getCount() {
            return mfragment.size();
        }
    }

}
