package com.projectassyifa.eserviceapplication.screen.alert

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.DialogFragment
import com.projectassyifa.eserviceapplication.R

class Done (val mActivity: DialogFragment) {
    private lateinit var isdialog: AlertDialog

    fun startLoading() {

        val infalter = mActivity.layoutInflater
        val dialogView = infalter.inflate(R.layout.done, null)

        val bulider = AlertDialog.Builder(mActivity.context)

        bulider.setView(dialogView)
        bulider.setCancelable(false)
        isdialog = bulider.create()
        isdialog.show()
        isdialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
    }

    fun isDismiss() {
        isdialog.dismiss()
    }
}