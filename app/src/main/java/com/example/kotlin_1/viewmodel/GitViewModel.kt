package com.example.kotlin_1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_1.dataclass.RetrofitData
import com.lubnamariyam.retrofitwithmvvm.network.RetrofitInstance
import com.lubnamariyam.retrofitwithmvvm.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitViewModel : ViewModel() {
    var gitHubDataList = MutableLiveData<List<RetrofitData>>()

    fun getApiData(){
        /*val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)*/
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        retrofitInstance.getDataFromApi().enqueue(object : Callback<List<RetrofitData>>{
            override fun onResponse(
                call: Call<List<RetrofitData>>,
                response: Response<List<RetrofitData>>
            ) {
                gitHubDataList.value = response.body()
            }

            override fun onFailure(call: Call<List<RetrofitData>>, t: Throwable) {

            }

        })

    }

}