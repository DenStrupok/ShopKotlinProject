package com.example.shopkotlinproject.domain

import android.util.Log
import com.example.shopkotlinproject.MainActivity.Companion.MY_TAG
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.presentation.chooseBook.ListBooksOrder
import java.util.stream.Collector

class BooksInteractor {
    var summary = 0
    private val listCheckedBooks = mutableListOf<Book>()

    fun addBookToOrder(books: Book): MutableList<Book> {
        while (true) {
            if (listCheckedBooks.isEmpty()) {
                listCheckedBooks.add(books)
                break
            } else {
                for (i in listCheckedBooks.indices) {
                    listCheckedBooks[i].name != books.name
                    if (listCheckedBooks[i].name == books.name) {
                        listCheckedBooks[i].number++
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
    fun getSummaryBooksOrder(list: MutableList<Book>): Int{
        for (i in list.indices){
            summary += list[i].number * list[i].price
        }
        return summary
    }
}


