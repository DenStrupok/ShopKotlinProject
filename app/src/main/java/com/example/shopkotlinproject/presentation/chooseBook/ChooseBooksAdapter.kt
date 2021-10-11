package com.example.shopkotlinproject.presentation.chooseBook

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.BookUI

class ChooseBooksAdapter(
    private val context: Context,
    private val listener: ItemClickRecyclerView
) :
    RecyclerView.Adapter<ChooseBooksAdapter.MyViewHolder>() {

    private var listBooks = mutableListOf<BookUI>()
    fun passListBookAdapter(list: MutableList<BookUI>) {
        listBooks = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChooseBooksAdapter.MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_list_books, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ChooseBooksAdapter.MyViewHolder, position: Int) {
        Glide.with(context).load(listBooks[position].book_image).into(holder.imgBook)
        holder.tvNameBook.text = listBooks[position].title
        holder.tvAuthor.text = listBooks[position].author
        holder.tvPriceBook.text = listBooks[position].price.toString()
        holder.btnAddBookBasket.setOnClickListener {
            val checkedBook = listBooks[position]
//            listener.itemRecyclerClicked(checkedBook)
       }
    }
    override fun getItemCount(): Int {
        return listBooks.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBook: ImageView = itemView.findViewById(R.id.imgBook)
        val tvNameBook: TextView = itemView.findViewById(R.id.tvNameBook)
        val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
        val tvPriceBook: TextView = itemView.findViewById(R.id.tvPriceBook)
        val btnAddBookBasket: ImageButton = itemView.findViewById(R.id.btnAddBookBasket)

    }
}