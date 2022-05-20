package com.example.kotlin_1.adapterclass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_1.R
import com.example.kotlin_1.dataclass.RetrofitData


class GitHubAdapter(private val mList: List<RetrofitData>, var clickListner: OnItemClickListner) :
    RecyclerView.Adapter<GitHubAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitHubAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        holder.initialize(mList.get(position),clickListner)
        holder.textView1.text = ItemsViewModel.symbol
        holder.textView.text = ItemsViewModel.quoteAsset
        holder.textView2.text = ItemsViewModel.highPrice
        holder.textView3.text = ItemsViewModel.lowPrice
        holder.textView4.text = ItemsViewModel.volume
        holder.textView5.text = ItemsViewModel.lastPrice

//        holder.itemView.setOnClickListener {
//            onClickListner.OnItemClicked(position)
//        }


    }


    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val textView1: TextView = itemView.findViewById(R.id.txt_symbol)
        val textView: TextView = itemView.findViewById(R.id.txt_quoteasset)
        val textView2: TextView = itemView.findViewById(R.id.txt_highprice)
        val textView3: TextView = itemView.findViewById(R.id.txt_lowprice)
        val textView4: TextView = itemView.findViewById(R.id.txt_volume)
        val textView5: TextView = itemView.findViewById(R.id.txt_lastprice)

        fun initialize(item: RetrofitData, action: OnItemClickListner) {



            itemView.setOnClickListener{
                action.onItemClick(item,adapterPosition)
            }

        }
    }

}


interface OnItemClickListner {
    fun onItemClick(item: RetrofitData, position: Int)
}
