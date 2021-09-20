package com.example.shopkotlinproject.presentation.savedOrder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.LIST_BOOKS
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.ORDER

class SavedOrderFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_saved_order, container, false)
        val order = arguments?.getParcelable<Order>(ORDER)
        val list = arguments?.getParcelableArrayList<Book>(LIST_BOOKS)
        return view
    }
}