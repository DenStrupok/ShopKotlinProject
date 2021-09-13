 package com.example.shopkotlinproject.network

import com.example.shopkotlinproject.pojo.AllResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksAPI {
    @GET("svc/books/v3/lists/current/hardcover-fiction.json?api-key")
    fun getBooks(@Query("q") books: String?, @Query("api-key") key: String?): Call<AllResponse>
}