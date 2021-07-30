package com.projectassyifa.eserviceapplication.screen.alert

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.screen.hrd.UploadBerkas

class FileNull (val mActivity: UploadBerkas) {
    private lateinit var isdialog: AlertDialog

    fun startLoading() {

        val infalter = mActivity.layoutInflater
        val dialogView = infalter.inflate(R.layout.no_data, null)

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