package com.example.shopkotlinproject.domain

import android.util.Log
import com.example.shopkotlinproject.MainActivity.Companion.MY_TAG
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.BookUI
import com.example.shopkotlinproject.presentation.chooseBook.ListBooksOrder
import java.util.stream.Collector

class BooksInteractor {
    var summary = 0
    private val listCheckedBooks = mutableListOf<BookUI>()

    fun addBookToOrder(books: BookUI): MutableList<BookUI> {
        while (true) {
            if (listCheckedBooks.isEmpty()) {
                listCheckedBooks.add(books)
                break
            } else {
                for (i in listCheckedBooks.indices) {
                    listCheckedBooks[i].title != books.title
                    if (listCheckedBooks[i].title == books.title) {
                        listCheckedBooks[i].price++
                        listCheckedBooks.remove(books)
                        break
                    }
                }
                listCheckedBooks.add(books)
            }
            return listCheckedBooks
        }
        getSummaryBooksOrder(listCheckedBooks)
        return listCheckedBooks
    }
    private fun getSummaryBooksOrder(list: MutableList<BookUI>): Int{
        for (i in list.indices){
 //           summary += list[i].price * list[i].price
        }
        return summary
    }
}


