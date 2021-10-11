package com.example.shopkotlinproject.data

import android.content.Context
import android.widget.Toast
import com.example.shopkotlinproject.network.BooksAPI
import com.example.shopkotlinproject.pojo.*
import com.example.shopkotlinproject.presentation.chooseBook.CreateListBooks
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChooseBooksModel(val context: Context, val listener: CreateListBooks) {

    private val API_KEY = "C5Pi45ulxA4VQEP0wrnyLDz6aUzQ6Nc1"
    private val list: MutableList<BookUI> = mutableListOf()

    fun getBook() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: BooksAPI = retrofit.create(BooksAPI::class.java)
        val call = api.getBooks(API_KEY)
        call.enqueue(object : Callback<AllResponse> {
            override fun onResponse(call: Call<AllResponse>, response: Response<AllResponse>) {
                response.body()?.let { mapBooksUI(it) }
                listener.createdListBooks(list)
            }

            override fun onFailure(call: Call<AllResponse>, t: Throwable) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun mapBooksUI(response: AllResponse) {
        response.results?.books?.forEach {
            val author: String = it.author.toString()
            val title: String = it.title.toString()
            val img: String = it.book_image.toString()
            val description: String = it.description.toString()
            val price = 0.0
            val bookUI = BookUI(author, title, price, description, img)
            list.add(bookUI)
        }
    }
}