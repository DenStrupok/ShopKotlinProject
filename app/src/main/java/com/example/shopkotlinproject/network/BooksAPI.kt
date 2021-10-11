 package com.example.shopkotlinproject.network

import com.example.shopkotlinproject.pojo.AllResponse
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.BooksJSON
import com.example.shopkotlinproject.pojo.ResultBooks
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksAPI {
    @GET("svc/books/v3/lists/current/hardcover-fiction.json?")
    fun getBooks( @Query("api-key") key: String?): Call<AllResponse>
}