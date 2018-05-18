package com.example.administrator.l_app.Ul.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.l_app.R;
import com.example.administrator.l_app.Ul.bean.News;
import com.example.administrator.l_app.Ul.fragment.Adapter.NewsAdapter;
import com.example.administrator.l_app.Ul.net.HttpResult;
import com.example.administrator.l_app.Ul.net.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment {
    private RecyclerView mrecyclerView;
    private View mview;
    private List<News> mnews;
    private NewsAdapter mNewsAdapter;
    public NewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview= inflater.inflate(R.layout.fragment_new, container, false);
        initview();
        init();
        return mview;
    }

    private void initview() {
        mrecyclerView=(RecyclerView)mview.findViewById(R.id.recycler_view);
    }
    private void init(){
        mnews=new ArrayList<>();
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsAdapter=new NewsAdapter(R.layout.item_view_new,mnews);
        mrecyclerView.setAdapter(mNewsAdapter);

        RetrofitUtil.getNews(new Callback<HttpResult<List<News>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<News>>> call, Response<HttpResult<List<News>>> response) {
                mNewsAdapter.addData(response.body().getData());
            }

            @Override
            public void onFailure(Call<HttpResult<List<News>>> call, Throwable t) {

            }
        });

    }

}
