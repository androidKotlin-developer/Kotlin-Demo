package com.example.kotlin_1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_1.R
import com.example.kotlin_1.adapterclass.GitHubAdapter
import com.example.kotlin_1.adapterclass.OnItemClickListner
import com.example.kotlin_1.dataclass.RetrofitData
import com.example.kotlin_1.viewmodel.GitViewModel
import kotlinx.android.synthetic.main.activity_retrofir_prac.*

class Retrofir_prac : AppCompatActivity() , OnItemClickListner {

    lateinit var githubInitViewModel: GitViewModel
    var mlist = ArrayList<RetrofitData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofir_prac)

        loadData()

    }
    fun loadData(){
        githubInitViewModel = ViewModelProvider(this).get(GitViewModel::class.java)
        githubInitViewModel.getApiData()
        githubInitViewModel.gitHubDataList.observe(this, Observer {
            initAdapter(it)
        })
    }

    fun initAdapter(data:List<RetrofitData>){
        recyclerVi.layoutManager = LinearLayoutManager(this)
        // This will pass the ArrayList to our Adapter
        val adapter = GitHubAdapter(data,this)
        // Setting the Adapter with the recyclerview
        recyclerVi.adapter = adapter

    }

    override fun onItemClick(item: RetrofitData, position: Int) {

        val intent = Intent(this, Retrofit_profile::class.java)
        intent.putExtra("symbol", item.symbol)
        intent.putExtra("baseAsset", item.baseAsset)
        intent.putExtra("quoteAsset", item.quoteAsset)
        intent.putExtra("volume", item.volume)
        intent.putExtra("openprice", item.openPrice)
        intent.putExtra("highPrice", item.highPrice)
        intent.putExtra("lowPrice", item.lowPrice)
        intent.putExtra("lastPrice", item.lastPrice)
        startActivity(intent)


    }


}