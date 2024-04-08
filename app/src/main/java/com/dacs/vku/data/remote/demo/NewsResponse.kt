package com.dacs.vku.data.remote.demo

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)