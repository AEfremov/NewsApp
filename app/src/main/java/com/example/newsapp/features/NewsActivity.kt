package com.example.newsapp.features

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.core.platform.BaseActivity
import com.example.newsapp.core.platform.BaseFragment

class NewsActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, NewsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun fragment(): BaseFragment = NewsFragment()
}