package com.example.shopkotlinproject.presentation.chooseBook

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopkotlinproject.data.ChooseBooksModel
import com.example.shopkotlinproject.domain.BooksInteractor
import com.example.shopkotlinproject.presentation.confirmOrder.ReceivedBooks
import com.example.shopkotlinproject.pojo.Book

class ChooseBooksViewModel(application: Application) : AndroidViewModel(application),
    CreateListBooks,
    ListBooksOrder {

    private val listBooksModel = ChooseBooksModel(application.baseContext, this)
    private val booksInteractor = BooksInteractor()
    private val mBookListLiveData = MutableLiveData<MutableList<Book>>()
    private val mOrderBooksList = MutableLiveData<MutableList<Book>>()

    init {
        listBooksModel.crateListBooks()
    }

    fun passListViewModel(selectedBooks: Book) {
        mOrderBooksList.value = booksInteractor.addBookToOrder(selectedBooks)
    }

    fun getOrderBooksList(): LiveData<MutableList<Book>> {
        return mOrderBooksList
    }

    fun getListBooks(): LiveData<MutableList<Book>> {
        return mBookListLiveData
    }


    override fun createdListBooks(listBooks: MutableList<Book>) {
        mBookListLiveData.value = listBooks
    }

    override fun listBooksOrder(listBooksOrder: MutableList<Book>) {
        mOrderBooksList.value = listBooksOrder
    }
}