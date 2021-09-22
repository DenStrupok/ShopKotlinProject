package com.example.shopkotlinproject.presentation.chooseBook

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkotlinproject.MainActivity
import com.example.shopkotlinproject.MainActivity.Companion.MY_TAG
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import com.example.shopkotlinproject.presentation.confirmOrder.ConfirmOrderFragment.Companion.LIST_BOOKS_BASKET
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.LIST_BOOKS
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.ORDER
import com.example.shopkotlinproject.presentation.resultOrder.ResultOrderFragment.Companion.ORDER_ID


class ChooseBooksFragment : Fragment(), ItemClickRecyclerView, View.OnClickListener {

    private lateinit var chooseBooksViewModel: ChooseBooksViewModel
    private var menuItem: MenuItem? = null
    private lateinit var tvBadgeCounter: TextView
    private lateinit var navController: NavController
    private var listSelectedBooks = mutableListOf<Book>()
    private val bundle = Bundle()
    private var order: Order? = null
    private lateinit var listBooks: MutableList<Book>
    private lateinit var btnListOrder: ImageButton
    private var orderID: Int? = null
    private lateinit var tvBadgeOrderCounter: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        chooseBooksViewModel = ViewModelProviders.of(this)[ChooseBooksViewModel::class.java]
        val view: View = inflater.inflate(R.layout.fragment_choose_books, container, false)
        order = arguments?.getParcelable(ORDER)
        navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        orderID = arguments?.getInt(ORDER_ID)
        setHasOptionsMenu(true)
        toolbar.title = "Choose book"
        (activity as MainActivity?)?.setSupportActionBar(toolbar)
        btnListOrder = view.findViewById(R.id.btnListOrder)
        btnListOrder.setOnClickListener(this)
        tvBadgeOrderCounter = view.findViewById(R.id.tvBadgeOrderCounter)
        tvBadgeOrderCounter.visibility = View.GONE
        btnListOrder.visibility = View.GONE
        order?.let { hideShowImageButton(it) }
        val rvListBook: RecyclerView = view.findViewById(R.id.rvListBook)
        val adapter = ChooseBooksAdapter(requireContext(), this)
        rvListBook.adapter = adapter
        chooseBooksViewModel.getListBooks().observe(viewLifecycleOwner, {
            adapter.passListBookAdapter(it)
        })
        chooseBooksViewModel.getOrderBooksList().observe(viewLifecycleOwner, Observer {
            listSelectedBooks = it
        })
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shop_notification, menu)
        menuItem = menu.findItem(R.id.nav_notification)
        menuItem?.setActionView(R.layout.notification_badge)
        val view: View = menuItem!!.actionView
        menuItem?.actionView?.setOnClickListener(this)
        tvBadgeCounter = view.findViewById(R.id.tvBadgeCounter)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun itemRecyclerClicked(selectedBook: Book) {
        chooseBooksViewModel.passListViewModel(selectedBook)
        tvBadgeCounter.text = listSelectedBooks.size.toString()
        bundle.putParcelableArrayList(LIST_BOOKS_BASKET, listSelectedBooks as ArrayList<Book>)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.nav_notification -> {
                if (bundle.isEmpty) {
                    Toast.makeText(requireContext(), "Add book to basket", Toast.LENGTH_LONG).show()
                } else navController.navigate(R.id.confirmOrderFragment, bundle)
            }
            R.id.btnListOrder -> {
                listBooks = arguments?.getParcelableArrayList<Book>(LIST_BOOKS)!!
                val bundle = Bundle()
                bundle.putParcelable(ORDER, order)
                bundle.putParcelableArrayList(LIST_BOOKS, listBooks as ArrayList<Book>)
                orderID?.let { bundle.putInt(ORDER_ID, it) }
                navController.navigate(R.id.savedOrderFragment, bundle)
            }
        }
    }
    private fun hideShowImageButton(order: Order){
        btnListOrder.visibility = View.VISIBLE
        tvBadgeOrderCounter.visibility = View.VISIBLE
    }
}


