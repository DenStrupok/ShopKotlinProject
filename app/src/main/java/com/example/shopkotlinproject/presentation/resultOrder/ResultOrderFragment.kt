package com.example.shopkotlinproject.presentation.resultOrder

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkotlinproject.R
import com.example.shopkotlinproject.pojo.Book
import com.example.shopkotlinproject.pojo.Order
import com.example.shopkotlinproject.presentation.dialog.ResultDialogFragment

class ResultOrderFragment: Fragment(), View.OnClickListener {

    private lateinit var resultOrderViewModel: ResultOrderViewModel
    private lateinit var navController: NavController
    private lateinit var dialog: Dialog
    companion object{
        const val ORDER = "order "
        const val LIST_BOOKS = "list books"
        const val SUMMARY_LIST_BOOKS = "summary list books"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        resultOrderViewModel = ViewModelProviders.of(this)[ResultOrderViewModel::class.java]
        val view: View = inflater.inflate(R.layout.fragment_result_order, container, false)
        val order = arguments?.getParcelable<Order>(ORDER)
        val resultOrderAdapter = ResultOrderAdapter()
        val rvResultOrder: RecyclerView = view.findViewById(R.id.rvResultOrder)
        rvResultOrder.adapter = resultOrderAdapter
        val list = arguments?.getParcelableArrayList<Book>(LIST_BOOKS)
        if (list !=null){
            resultOrderAdapter.passListBookOrderAdapter(list)
        }
        val tvSummaryListBooks: TextView = view.findViewById(R.id.tvSummaryListBooks)
        tvSummaryListBooks.text = "Summary order: ${arguments?.getInt(SUMMARY_LIST_BOOKS)} $"
        val tvNumberOrder: TextView = view.findViewById(R.id.tvNumberOrder)
        tvNumberOrder.text = "Order's number:  " + resultOrderViewModel.getOrderID(order!!)
        navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment)
        val tvResultNameClient: TextView = view.findViewById(R.id.tvResultNameClient)
        val tvResultFamilyClient: TextView = view.findViewById(R.id.tvResultFamilyClient)
        val tvResultPhoneClient: TextView = view.findViewById(R.id.tvResultPhoneClient)
        tvResultNameClient.text = "Name: " + order.nameClient
        tvResultFamilyClient.text = "Family: " + order.familyClient
        tvResultPhoneClient.text = "Phone: " + order.phoneNumber
        val btnBack: Button = view.findViewById(R.id.btnBack)
        btnBack.setOnClickListener(this)
        return view
    }
    private fun showDialog(){
        dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.result_dialog)
        dialog.show()
        val btnResultSave: Button = dialog.findViewById(R.id.btnResultSave)
        val btnResultFinish : Button = dialog.findViewById(R.id.btnResultFinish)
        btnResultFinish.setOnClickListener(this)
        btnResultSave.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnBack -> showDialog()
            R.id.btnResultSave -> Toast.makeText(requireContext(), "Save click", Toast.LENGTH_LONG).show()
            R.id.btnResultFinish -> {
                Toast.makeText(requireContext(), "Our manager will be call ", Toast.LENGTH_LONG).show()
                navController.navigate(R.id.chooseBooksFragment)
                dialog.dismiss()
            }
        }
    }
}