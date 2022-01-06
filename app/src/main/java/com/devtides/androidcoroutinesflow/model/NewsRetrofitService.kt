package com.devtides.androidcoroutinesflow.model

import com.devtides.androidcoroutinesretrofit.model.NewsArticle
import retrofit2.http.GET

interface NewsRetrofitService {

    //Retrofit to communicate with backend service


    /*this function is suspend because we will use it in the context of coroutine*/
    @GET("news.json")
    suspend fun getNews():List<NewsArticle>
}