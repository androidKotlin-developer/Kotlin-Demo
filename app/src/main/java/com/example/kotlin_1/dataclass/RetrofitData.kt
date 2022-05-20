package com.example.kotlin_1.dataclass

data class RetrofitData(
    val symbol: String,
    val baseAsset: String,
    val quoteAsset: String,
    val openPrice: String,
    val lowPrice: String,
    val highPrice: String,
    val lastPrice: String,
    val volume: String,
    val bidPrice: String,
    val askPrice: String,
    val at: String
)