package com.example.shopkotlinproject.presentation.confirmOrder

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.pojo.Book

class ConfirmOrderAdapter(private val listener: ReceivedBooks) :
    RecyclerView.Adapter<ConfirmOrderAdapter.MyViewHolder>() {

    private var listBooks: MutableList<Book> = mutableListOf()


    fun passListAdapter(list: MutableList<Book>) {
        listBooks = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConfirmOrderAdapter.MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rv_list_book_basket, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ConfirmOrderAdapter.MyViewHolder, position: Int) {
        holder.tvNameBookBasket.text = listBooks[position].name
        holder.tvPriceBookBasket.text = "${listBooks[position].price}  $"
        holder.btnMinus.setOnClickListener {
            listBooks[position].number--
            if (listBooks[position].number < 0){
                holder.btnMinus.isClickable = false
            }else{
                listener.receivedListBooks(listBooks)
                notifyDataSetChanged()
            }
        }
        holder.btnPlus.setOnClickListener {
            listBooks[position].number++
            listener.receivedListBooks(listBooks)
            notifyDataSetChanged()
        }
        holder.btnDeleteBook.setOnClickListener {
            listBooks.removeAt(position)
            listener.receivedListBooks(listBooks)
            notifyDataSetChanged()
        }
        holder.tvNumberBooks.text = listBooks[position].number.toString()
    }

    override fun getItemCount(): Int {
        return listBooks.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNameBookBasket: TextView = itemView.findViewById(R.id.tvNameBookBasket)
        val tvPriceBookBasket: TextView = itemView.findViewById(R.id.tvPriceBookBasket)
        val btnMinus: ImageButton = itemView.findViewById(R.id.btnMinus)
        var tvNumberBooks: TextView = itemView.findViewById(R.id.tvNumberBooks)
        val btnPlus: ImageButton = itemView.findViewById(R.id.btnPlus)
        val btnDeleteBook: ImageButton = itemView.findViewById(R.id.btnDeleteBook)
    }
}
