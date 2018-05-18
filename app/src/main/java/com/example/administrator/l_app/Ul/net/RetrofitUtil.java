package com.example.administrator.l_app.Ul.net;

import com.example.administrator.l_app.Ul.bean.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/9.
 */

public class RetrofitUtil {
    //通过retrofit实现网络请求的封装
    public static void getNews(Callback<HttpResult<List<News>>> callback){
        //创建retrofit实例
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://211.67.147.26/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiservice apiservice=retrofit.create(Apiservice.class);
        Call<HttpResult<List<News>>> call=apiservice.getNews();
        call.enqueue(callback);

    }
}
