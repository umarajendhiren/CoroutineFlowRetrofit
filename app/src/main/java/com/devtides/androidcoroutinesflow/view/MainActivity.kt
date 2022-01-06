package com.devtides.androidcoroutinesflow.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.devtides.androidcoroutinesflow.R
import com.devtides.androidcoroutinesflow.viewmodel.ListViewModel
import com.devtides.coroutinesretrofit.view.NewsListAdapter
import kotlinx.android.synthetic.main.activity_main.*

/*objective:
* get news from backend using Retrofit
* convert that list of news into flow using coroutine flow
* Then convert  the emitted  flow to livedata in viewModel
* finally, Activity observes newsArticle livedata and update the UI  */

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val newsListAdapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        newsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.newsArticles.observe(this, Observer { article ->

            loading_view.visibility = View.GONE
            newsList.visibility = View.VISIBLE
            //this will add item at index 0
            newsListAdapter.onAddNewsItem(article)
            newsList.smoothScrollToPosition(0)


        })
    }
}
