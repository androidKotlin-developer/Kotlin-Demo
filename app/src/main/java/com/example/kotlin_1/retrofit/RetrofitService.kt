package com.lubnamariyam.retrofitwithmvvm.network

import com.example.kotlin_1.dataclass.RetrofitData

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("24hr")
    fun getDataFromApi(): Call<List<RetrofitData>>

}