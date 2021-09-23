package com.example.shopkotlinproject.presentation.savedOrder

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.databinding.FragmentSavedOrderBinding
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import com.example.shopkotlinproject.presentation.adapter.ListBooksAdapter
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.LIST_BOOKS
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.ORDER
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.ORDER_ID
import org.w3c.dom.Text

class SavedOrderFragment: Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSavedOrderBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_saved_order, container, false )
        val view: View = binding.root
        val order = arguments?.getParcelable<Order>(ORDER)
        val list = arguments?.getParcelableArrayList<Book>(LIST_BOOKS)
        val adapter = ListBooksAdapter()
        list?.let { adapter.sendBooksAdapter(it) }
        binding.rvSavedFragment.adapter = adapter
        val orderID = arguments?.getInt(ORDER_ID)
        binding.tvSavedOrderID.text = "Order's number ${orderID.toString()}"
        binding.tvSavedOrderClientName.text = "Client name:   ${order?.nameClient.toString()}"
        binding.tvSavedOrderClientFamily.text = "Client family:   ${order?.familyClient.toString()}"
        binding.tvSavedOrderClientPhone.text = "Client phone:   ${order?.phoneNumber.toString()}"
        return view
    }
}