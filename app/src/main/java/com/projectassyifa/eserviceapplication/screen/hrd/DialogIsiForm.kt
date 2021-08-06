package com.projectassyifa.eserviceapplication.screen.hrd

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.projectassyifa.eserviceapplication.R
import kotlinx.android.synthetic.main.fragment_dialog_isi_form.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

class DialogIsiForm : DialogFragment() {
    var dataLogin : SharedPreferences? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner);
        dataLogin = activity?.getSharedPreferences(
            getString(R.string.shared_preference_name),
            Context.MODE_PRIVATE
        )
        val tmt = dataLogin?.getString(
            getString(R.string.tanggal_mulai_tugas),
            getString(R.string.default_value)
        )

        println("TMT $tmt")
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val currentDate = sdf.format(Date())
        System.out.println(" C DATE is  "+currentDate)

        val monthsBetween: Long = ChronoUnit.MONTHS.between(
            LocalDate.parse(tmt).withDayOfMonth(1),
            LocalDate.parse(currentDate).withDayOfMonth(1)
        )





        var rootView : View = inflater.inflate(R.layout.fragment_dialog_isi_form,container,false)

        var btnform = rootView.findViewById<Button>(R.id.btn_isiform)
        var syaratcuti = rootView.findViewById<TextView>(R.id.syaratcuti)

        println("BULAN $monthsBetween") //3
        if (arguments?.getString("title") == "Ketentuan Cuti"){
            if (monthsBetween < 12){
                syaratcuti.isVisible= true
                btnform.visibility = View.GONE
            } else {
                syaratcuti.isVisible=false
                btnform.visibility= View.VISIBLE
                btnform.setOnClickListener {
                    var move = Intent(this.context,FormCutiActivity::class.java)
                    startActivity(move)
                }
            }
        }

        if (arguments?.getString("title") == "Ketentuan Izin"){
            syaratcuti.isVisible=false
            btnform.setOnClickListener {
                var move = Intent(this.context,FormIzinActivity::class.java)
                startActivity(move)
            }
        }

        var judul = rootView.findViewById<TextView>(R.id.titleForm)
        var poin1 = rootView.findViewById<TextView>(R.id.point1)
        var poin2 = rootView.findViewById<TextView>(R.id.point2)
        var poin3 = rootView.findViewById<TextView>(R.id.point3)

        judul.setText(arguments?.getString("title"))
        poin1.setText(arguments?.getString("point_1"))
        poin2.setText(arguments?.getString("point_2"))
        poin3.setText(arguments?.getString("point_3"))


        return rootView
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}