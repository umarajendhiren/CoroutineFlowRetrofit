package com.devtides.androidcoroutinesflow.model

import com.devtides.androidcoroutinesretrofit.model.NewsArticle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {

    
    companion object{

      private const val BASE_URL= "https://raw.githubusercontent.com/DevTides/NewsApi/master/"
        private const val NEWS_DELAY=2000L
    }
   
private val newsService = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(NewsRetrofitService::class.java)

/*this function get the news from backend (list of NewsArticle)and convert into flow and emit each value with delay of 2000ms */
    fun getNewsArticle(): Flow<NewsArticle>{

        return flow {
            var newsResponse = newsService.getNews()
            newsResponse.forEach{
                emit(it)
                delay(NEWS_DELAY)
            }

        }


    }

}