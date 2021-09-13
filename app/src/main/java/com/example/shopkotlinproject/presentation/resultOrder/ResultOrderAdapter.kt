package com.example.shopkotlinproject.presentation.resultOrder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.pojo.Book

class ResultOrderAdapter: RecyclerView.Adapter<ResultOrderAdapter.MyViewHolder>() {

    private var listBooks: MutableList<Book> = mutableListOf()
    fun passListBookOrderAdapter(list: MutableList<Book>){
        listBooks = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultOrderAdapter.MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_list_books_order, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ResultOrderAdapter.MyViewHolder, position: Int) {
        holder.tvNameBookResultOrder.text = listBooks[position].name
        holder.tvAuthorBookResultOrder.text = listBooks[position].author
        holder.tvNumberBookResultOrder.text = listBooks[position].number.toString()
    }

    override fun getItemCount(): Int {
    return listBooks.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNameBookResultOrder: TextView = itemView.findViewById(R.id.tvNameBookResultOrder)
        val tvAuthorBookResultOrder: TextView = itemView.findViewById(R.id.tvAuthorBookResultOrder)
        val tvNumberBookResultOrder: TextView = itemView.findViewById(R.id.tvNumberBookResultOrder)
    }
}