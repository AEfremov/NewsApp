package com.example.newsapp.features

import android.os.Parcel
import com.example.newsapp.core.platform.KParcelable
import com.example.newsapp.core.platform.parcelableCreator
import com.squareup.moshi.Json

data class ArticleView(
        val author: String?,
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String,
        val content: String
) : KParcelable {

    companion object {
        @JvmField val CREATOR = parcelableCreator(::ArticleView)
    }

    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        with(dest) {
            writeString(author)
            writeString(title)
            writeString(description)
            writeString(url)
            writeString(urlToImage)
            writeString(publishedAt)
            writeString(content)
        }
    }
}