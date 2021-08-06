package com.projectassyifa.eserviceapplication.screen.ruangrapat

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.container.MyApplication
import com.projectassyifa.eserviceapplication.data.pegawai.adapter.AdapterEmployee
import com.projectassyifa.eserviceapplication.data.pegawai.viewmodel.EmployeeVM
import com.projectassyifa.eserviceapplication.data.ruangrapat.adapter.AdapterRoomList
import com.projectassyifa.eserviceapplication.data.ruangrapat.model.MeetingRoomModel
import com.projectassyifa.eserviceapplication.data.ruangrapat.viewmodel.ListRoomVM
import com.projectassyifa.eserviceapplication.data.ruangrapat.viewmodel.MeetingRoomVM
import com.projectassyifa.eserviceapplication.screen.alert.Done
import com.projectassyifa.eserviceapplication.screen.alert.FileNull
import com.zues.searchable_spinner.SearchableSpinner
import kotlinx.android.synthetic.main.activity_health_care_employee.*
import kotlinx.android.synthetic.main.activity_health_care_employee.date
import kotlinx.android.synthetic.main.fragment_add_schedule.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class AddSchedule : DialogFragment() {
    var dataLogin : SharedPreferences? = null
    var cal = Calendar.getInstance()
    var tanggal_ajuan : String ? = null
    var selectEmployee : String? = null
    var id_ruangan : String ? = null

    @Inject
    lateinit var listRoomVM : ListRoomVM
    lateinit var adapterRoomList : AdapterRoomList

    @Inject
    lateinit var meetingRoomVM: MeetingRoomVM

    @Inject
    lateinit var employeeVM: EmployeeVM
    lateinit var adapterEmployee: AdapterEmployee


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        (activitin = activity?.getSharedPreferences(
//            getStriy?.applicationContext as MyApplication).applicationComponent.inject(this)
////        dataLogng(R.string.shared_preference_name),
//            Context.MODE_PRIVATE
//        )
//        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner);
//        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
//        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView : View = inflater.inflate(R.layout.fragment_add_schedule,container,false)
        (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
        dataLogin = activity?.getSharedPreferences(
            getString(R.string.shared_preference_name),
            Context.MODE_PRIVATE
        )

        var btnTgl = rootView.findViewById<TextView>(R.id.tgl)
        var btnJam1 = rootView.findViewById<TextView>(R.id.jam1)
        var btnJam2 = rootView.findViewById<TextView>(R.id.jam2)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }


        btnTgl.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                context?.let {
                    DatePickerDialog(
                        it,
                        dateSetListener,
                        // set DatePickerDialog to point to today's date when it loads up
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)
                    ).show()
                }
            }

        })

        btnJam1.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                btnJam1.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }

        btnJam2.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                btnJam2.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }

        //ruangan
        listRoomVM.listroom?.observe(viewLifecycleOwner,Observer{
            adapterRoomList = AdapterRoomList(requireActivity(),it)
            spinner_ruangan.adapter = adapterRoomList


            //select
            spinner_ruangan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    println("RUANGAN ${it[position].nama_ruangan}")
                    id_ruangan = it[position].id_ruangan
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    println("no item select")
                }

            }
        })
        listRoomVM.room()

        //pic
        employeeVM.data_employee?.observe(viewLifecycleOwner, Observer {
            adapterEmployee = context?.let { it1 -> AdapterEmployee(it, it1) }!!
            var data = adapterEmployee.dataSource
            var tampung : ArrayList<String> = ArrayList()
            // append list employee to spinner
            data.forEach {
                tampung.add(it.nama_pegawai)
                employee_list.setItems(tampung)

            }

            //select employee
            employee_list.setOnItemSelectListener(object :  SearchableSpinner.SearchableItemListener {
                override fun onItemSelected(view: View?, position: Int) {
//                   var container = employee_list.mSelectedItem.toString()
//                    employeeVM.data_employee?.observe(viewLifecycleOwner, Observer {
//                        selectEmployee = it[0].nama_pegawai
//                        println("SELECT $selectEmployee")
//                    })
                    selectEmployee = employee_list.mSelectedItem.toString()
                    println("SELECT $selectEmployee")

                }

                override fun onSelectionClear() {
              println("pass")
                }

            })
        })
        employeeVM.employee()

        val username = dataLogin?.getString(
            getString(R.string.username),
            getString(R.string.default_value)
        )

        var btn_save = rootView.findViewById<Button>(R.id.btn_add_schedule)
        btn_save.setOnClickListener {
           var  content_data = MeetingRoomModel()
            content_data.peminjam = peminjam.text.toString()
            content_data.tanggal = tgl.text.toString()
            content_data.jam_mulai = jam1.text.toString()
            content_data.jam_selesai = jam2.text.toString()
            content_data.ruangan = id_ruangan.toString()
            content_data.pic =  selectEmployee.toString()
            content_data.keperluan = keperluan.text.toString()
            content_data.remark = keterangan.text.toString()
            content_data.created_by = username.toString()
            meetingRoomVM.add_schedule(content_data)
            val loading = Done(this)
            loading.startLoading()
            val handler = Handler()
            handler.postDelayed(object :Runnable{
                override fun run() {
                    loading.isDismiss()
                }

            },3000)
            dismiss()

            println("${content_data.tanggal},${content_data.jam_mulai},${content_data.jam_selesai},${content_data.ruangan},${content_data.pic},${content_data.keperluan},${content_data.remark},")
        }

        return rootView
    }



    private fun updateDateInView() {
        val myFormat = "dd/M/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        tgl.text = sdf.format(cal.getTime())
        tanggal_ajuan = sdf.format(cal.getTime())
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner);
    }

}