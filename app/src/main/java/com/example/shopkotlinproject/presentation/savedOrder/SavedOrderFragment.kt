package com.example.shopkotlinproject.presentation.savedOrder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import com.example.shopkotlinproject.presentation.adapter.ListBooksAdapter
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.LIST_BOOKS
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.ORDER
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.ORDER_ID
import org.w3c.dom.Text

class SavedOrderFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_saved_order, container, false)
        val order = arguments?.getParcelable<Order>(ORDER)
        val list = arguments?.getParcelableArrayList<Book>(LIST_BOOKS)
        val rvSavedFragment: RecyclerView = view.findViewById(R.id.rvSavedFragment)
        val adapter = ListBooksAdapter()
        list?.let { adapter.sendBooksAdapter(it) }
        rvSavedFragment.adapter = adapter
        val orderID = arguments?.getInt(ORDER_ID)
        val tvSavedOrderID: TextView = view.findViewById(R.id.tvSavedOrderID)
        val tvSavedOrderClientName: TextView = view.findViewById(R.id.tvSavedOrderClientName)
        val tvSavedOrderClientFamily: TextView = view.findViewById(R.id.tvSavedOrderClientFamily)
        val tvSavedOrderClientPhone: TextView = view.findViewById(R.id.tvSavedOrderClientPhone)
        tvSavedOrderID.text = orderID.toString()
        tvSavedOrderClientName.text = order?.nameClient.toString()
        tvSavedOrderClientFamily.text = order?.familyClient.toString()
        tvSavedOrderClientPhone.text = order?.phoneNumber.toString()
        return view
    }
}