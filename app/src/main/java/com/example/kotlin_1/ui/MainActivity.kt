package com.example.kotlin_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_1.R
import com.example.kotlin_1.adapterclass.CustomAdapter
import com.example.kotlin_1.viewmodel.CategoryViewModel

class MainActivity : AppCompatActivity() {
    lateinit var  rview : RecyclerView
    lateinit var adaptercustom : CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findid()

        var catemodel : CategoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)

        catemodel.getArraylist().observe(this, Observer {

            adaptercustom = CustomAdapter(this,it)
            rview.layoutManager = LinearLayoutManager(this)

            rview.adapter = adaptercustom


        })

    }
    private fun findid(){
        rview =findViewById(R.id.mrecycleview)
    }

}