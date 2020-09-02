package com.example.newsapp.features

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.core.extension.inflate
import com.example.newsapp.core.navigation.Navigator
import kotlinx.android.synthetic.main.row_article.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class NewsAdapter
@Inject constructor() : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    internal var collection: List<ArticleView> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    internal var clickListener: (ArticleView, Navigator.Extras) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.row_article))

    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(collection[position], clickListener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(articleView: ArticleView, clickListener: (ArticleView, Navigator.Extras) -> Unit) = with(itemView) {
            authorView.text = articleView.author
            titleView.text = articleView.title
            descriptionView.text = articleView.description
//            setOnClickListener { clickListener(articleView, Navigator.Extras()) }
        }
    }
}