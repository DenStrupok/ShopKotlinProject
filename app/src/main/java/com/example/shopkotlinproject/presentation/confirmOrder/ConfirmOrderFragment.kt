package com.example.shopkotlinproject.presentation.confirmOrder

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkotlinproject.MainActivity.Companion.MY_TAG
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.LIST_BOOKS
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.ORDER
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.SUMMARY_LIST_BOOKS
import java.util.ArrayList

class ConfirmOrderFragment : Fragment(), ReceivedBooks, TextWatcher {

    companion object {
        const val LIST_BOOKS_BASKET = "list books basket"
    }

    private lateinit var navController: NavController
    private lateinit var tvTotalSummaryOrder: TextView
    private lateinit var confirmOrderViewModel: ConfirmOrderViewModel
    private lateinit var edClientName: EditText
    private lateinit var edClientFamily: EditText
    private lateinit var edClientPhone: EditText
    private lateinit var btnConfirmOrder: Button
    private var isButtonClicked = false
    private var summaryListBooks = 0

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        confirmOrderViewModel = ViewModelProviders.of(this)[ConfirmOrderViewModel::class.java]
        val listBooks: MutableList<Book> =
            arguments?.getParcelableArrayList<Book>(LIST_BOOKS_BASKET) as MutableList<Book>
        confirmOrderViewModel.summaryOrder(listBooks)
        navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment)
        val view: View = inflater.inflate(R.layout.fragment_confirm_order, container, false)
        edClientName = view.findViewById(R.id.edClientName)
        edClientFamily = view.findViewById(R.id.edClientFamily)
        edClientPhone = view.findViewById(R.id.edClientPhone)
        edClientName.addTextChangedListener(this)
        edClientFamily.addTextChangedListener(this)
        edClientPhone.addTextChangedListener(this)
        tvTotalSummaryOrder = view.findViewById(R.id.tvTotalSummaryOrder)
        val rvListBookOrder: RecyclerView = view.findViewById(R.id.rvListBookOrder)
        val orderAdapter = ConfirmOrderAdapter(this)
        orderAdapter.passListAdapter(listBooks)
        rvListBookOrder.adapter = orderAdapter
        rvListBookOrder.addItemDecoration(
            DividerItemDecoration(
                rvListBookOrder.context,
                DividerItemDecoration.VERTICAL
            )
        )
        btnConfirmOrder = view.findViewById(R.id.btnConfirmOrder)
        btnConfirmOrder.setOnClickListener {
            val bundle = Bundle()
            val order = Order(edClientName.text.toString(), edClientFamily.text.toString(), edClientPhone.text.toString())
            bundle.putParcelable(ORDER, order)
            bundle.putParcelableArrayList(LIST_BOOKS, listBooks as ArrayList<Book>)
            bundle.putInt(SUMMARY_LIST_BOOKS, summaryListBooks)
            navController.navigate(R.id.resultOrderFragment, bundle)
        }
        confirmOrderViewModel.getSummaryBooksOrder().observe(viewLifecycleOwner, Observer {
            summaryListBooks = it
            tvTotalSummaryOrder.text = "Total summary order: $it $"
        })
        confirmOrderViewModel.getClientValidation().observe(viewLifecycleOwner, Observer {
            isButtonClicked = it
            if (isButtonClicked) {
                btnConfirmOrder.isEnabled = true
            }
        })
        return view
    }

    override fun receivedListBooks(listBooks: MutableList<Book>?) {
        confirmOrderViewModel.summaryOrder(listBooks)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        Log.i(MY_TAG, "")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        confirmOrderViewModel.validationClientData(
            edClientName.text.toString(), edClientFamily.text.toString(),
            edClientPhone.text.toString()
        )
    }

    override fun afterTextChanged(s: Editable?) {
        Log.i(MY_TAG, "")
    }
}