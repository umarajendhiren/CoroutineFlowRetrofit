package com.devtides.androidcoroutinesflow.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.devtides.androidcoroutinesflow.model.NewsRepository

class ListViewModel: ViewModel() {

   // val newsArticles = MutableLiveData<String>()

    //here we are converting flow into LiveData
    val newsArticles=NewsRepository().getNewsArticle().asLiveData()

}