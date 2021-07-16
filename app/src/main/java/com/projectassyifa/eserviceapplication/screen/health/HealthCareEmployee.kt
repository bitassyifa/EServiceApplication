package com.projectassyifa.eserviceapplication.screen.health

import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.view.isVisible
import com.projectassyifa.eserviceapplication.R
import kotlinx.android.synthetic.main.activity_health_care_employee.*
import java.text.SimpleDateFormat
import java.util.*

class HealthCareEmployee : AppCompatActivity() {

    var dataLogin: SharedPreferences? = null
    var cal = Calendar.getInstance()
    var tanggal : String ? = null

    var sehat : String ? = null
    var perjalanan1 : String ? = null
    var gejala1 : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_care_employee)

        dataLogin = this.getSharedPreferences(
            getString(R.string.shared_preference_name),
            Context.MODE_PRIVATE
        )
        val nama = dataLogin?.getString(
            getString(R.string.nama_pegawai),
            getString(R.string.default_value)
        )

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        date.text = currentDate

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        date.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@HealthCareEmployee,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })

        nama_pegawai.text = "$nama, Apakah hari ini anda sehat ?"
        val myStrings = arrayOf("Pilih :","Ya", "Tidak")
        val sudahBelum = arrayOf("Pilih :","Sudah", "Belum")
        //sehat
        mySpinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, myStrings)


        mySpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                sehat = myStrings[position]
                println("sehat ? $sehat" )
                if (sehat == "Ya") {
                    perjalanan.isVisible = true
                    jbt_tgn.isVisible = true
                    gejala.isVisible = false
                    day_sakit.isVisible = false
                    kontak_erat.isVisible = false
                    suhu.isVisible = false
                    pergi.isVisible=false
                    swab.isVisible = false
                    periksa_dokter.isVisible=false
                    confirm.isVisible = true
                } else if (sehat == "Tidak"){
                    gejala.isVisible = true
                    day_sakit.isVisible = true
                    kontak_erat.isVisible = true
                    suhu.isVisible = true
                    periksa_dokter.isVisible=true
                    confirm.isVisible = true
                    pergi.isVisible=false
                    perjalanan.isVisible = false
                    jbt_tgn.isVisible = false
                }else {
                    confirm.isVisible = false
                    perjalanan.isVisible = false
                    jbt_tgn.isVisible = false
                    gejala.isVisible = false
                    day_sakit.isVisible = false
                    kontak_erat.isVisible = false
                    suhu.isVisible = false
                    periksa_dokter.isVisible=false
                    pergi.isVisible=false
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        //perjalanan luar kota
        spinner2.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, myStrings)


        spinner2.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
               perjalanan1 = myStrings[position]
                if (perjalanan1 == "Ya") {
                    pergi.isVisible=true
                } else if (perjalanan1 == "Tidak"){
                    pergi.isVisible=false
                } else {
                    pergi.isVisible=false
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        //jabat tgn
        spinner3.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, myStrings)


        spinner3.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(
                    this@HealthCareEmployee,
                    myStrings[position], Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        //gejala
        spinner4.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, myStrings)


        spinner4.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
               gejala1 = myStrings[position]
                if (gejala1 == "Ya") {
                    swab.isVisible = true
                } else {
                    swab.isVisible = false
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        //kontak erat
        spinner5.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, myStrings)


        spinner5.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(
                    this@HealthCareEmployee,
                    myStrings[position], Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        //pergi dokter
        spinner6.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sudahBelum)


        spinner6.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(
                    this@HealthCareEmployee,
                    sudahBelum[position], Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

        //swab
        spinner7.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, myStrings)


        spinner7.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(
                    this@HealthCareEmployee,
                    myStrings[position], Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }


    }

    private fun updateDateInView() {
        val myFormat = "dd/M/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        date.text = sdf.format(cal.getTime())
        tanggal = sdf.format(cal.getTime())
    }
}