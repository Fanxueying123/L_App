package com.example.administrator.l_app.Ul.net;

import com.example.administrator.l_app.Ul.bean.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/5/9.
 */

public interface Apiservice {
    //从服务器通过FET方法获取数据
   @GET("getnews.php")
    Call<HttpResult<List<News>>>getNews();
}
