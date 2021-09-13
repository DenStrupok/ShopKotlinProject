package com.example.shopkotlinproject.presentation.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shopkotlinproject.R

class ResultDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment)
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Do you want save order")
                .setCancelable(true)
                .setPositiveButton("Save") { dialog, id ->
                    dialog.cancel()
                }.setNegativeButton("Finish") { dialog, id -> navController.navigate(R.id.chooseBooksFragment)
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }
}