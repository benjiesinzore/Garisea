package com.garisea.views

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog

class HandleCustomDialog(private val context: Context) {

    private lateinit var alertDialog: AlertDialog

    fun showLoadingDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
        alertDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .setCancelable(false)
            .create()
        alertDialog.show()
    }

    fun hideLoadingDialog() {
        if (::alertDialog.isInitialized && alertDialog.isShowing) {
            alertDialog.dismiss()
        }
    }
}
