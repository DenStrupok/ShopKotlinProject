package com.example.shopkotlinproject.data

import android.content.Context
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.presentation.chooseBook.CreateListBooks

class ChooseBooksModel(val context: Context, val listener: CreateListBooks) {

    private val API_KEY = "kfcm5nAC644FvGSmLZf8VBAJHgX9MYXJ&fbclid"

//    fun getBook(nameBook: String) {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.nytimes.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val api: BooksAPI = retrofit.create(BooksAPI::class.java)
//        val call = api.getBooks(nameBook, API_KEY)
//        call.enqueue(object : Callback<AllResponse> {
//            override fun onResponse(call: Call<AllResponse>, response: Response<AllResponse>) {
//                listener.receivedListBooks(response.body())
//            }
//
//            override fun onFailure(call: Call<AllResponse>, t: Throwable) {
//                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
//            }
//
//        })
//    }

    fun crateListBooks() {
        var listBooks: MutableList<Book>? = null
        val image: Int = R.drawable.ic_book
        val oneBook = Book("Angels and Demons", "Den Brown", 15, image, 1)
        val twoBook = Book("Inferno", "Den Brown", 15, image,1)
        val threeBook = Book("The Da Vinci Code", "Den Brown", 15, image,1)
        val fourBook = Book("Deception Point", "Den Brown", 15, image,1)
        val fiveBook = Book("Origin", "Den Brown", 15, image,1)
        val sixBook = Book("The Lost Symbol", "Den Brown", 15, image,1)
        val sevenBook = Book("Digital Fortress", "Den Brown", 15, image,1)
        val eightBook = Book("American Marriage ", "Tayari Jones", 10, image,1)
        val nineBook = Book("Becoming", " Michelle Obama", 10, image,1)
        val tenBook = Book("Song of Solomon ", "Toni Morrison", 10, image,1)
        val elevenBook = Book("The Fountainhead", "Ayn Rand", 20, image,1)
        val twelveBook = Book("Collected works", "Dylan Thomas", 30, image,1)
        val thirteenBook = Book("Odyssey", "Homer", 25, image,1)
        val fourteenBook = Book("The Famous Five", "Enid Blyton", 10, image,1)
        val fifteenBook = Book("The Alchemist", "Paulo Coehlo", 8, image,1)
        val sixteenBook = Book("Moby Dick", "Herman Melville", 23, image,1)
        val seventeenBook = Book("The Grapes of Wrath", "John Steinbeck", 10, image,1)
        val eighteenBook = Book("1984", "George Orwell", 30, image,1)
        val nineteenBook = Book("In Cold Blood ", "Truman Capote", 5, image,1)
        val twentyBook = Book("DisneyWar", "James B. Stewart", 13, image,1)
        listBooks =  mutableListOf(
            oneBook,
            twoBook,
            threeBook,
            fourBook,
            fiveBook,
            sixBook,
            sevenBook,
            eightBook,
            nineBook,
            tenBook,
            elevenBook,
            twelveBook,
            thirteenBook,
            fourteenBook,
            fifteenBook,
            sixteenBook,
            seventeenBook,
            eighteenBook,
            nineteenBook,
            twentyBook
        )
        listener.createdListBooks(listBooks)
    }
}