package com.example.kotlin_1.adapterclass

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_1.R
import com.example.kotlin_1.databinding.CategoryBinding
import com.example.kotlin_1.viewmodel.CategoryViewModel


class CustomAdapter(private val context: Context,private val arraylist : ArrayList<CategoryViewModel>) : RecyclerView.Adapter<CustomAdapter.CustomView>(){


class CustomView (val categoryBinding: CategoryBinding ) : RecyclerView.ViewHolder(categoryBinding.root){

    fun bind (categoryViewModel: CategoryViewModel){

        this.categoryBinding.catebinding = categoryViewModel
        categoryBinding.executePendingBindings()
    }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        val layoutInflater = LayoutInflater.from(context)

        val categoryBinding : CategoryBinding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_design,parent,false)

        return CustomView(categoryBinding)

    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {
         val categoryViewModel = arraylist[position]
        holder.bind(categoryViewModel)


    }

    override fun getItemCount(): Int {

        return arraylist.size

    }

}