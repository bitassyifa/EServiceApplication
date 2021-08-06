package com.projectassyifa.eserviceapplication.screen.ruangrapat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.container.MyApplication
import com.projectassyifa.eserviceapplication.data.ruangrapat.adapter.AdapterScheduleNow
import com.projectassyifa.eserviceapplication.data.ruangrapat.viewmodel.MeetingRoomVM
import com.projectassyifa.eserviceapplication.screen.hrd.UploadBerkas
import kotlinx.android.synthetic.main.activity_meeting_room.*
import java.util.*
import javax.inject.Inject


class MeetingRoom : AppCompatActivity() {
    var dataLogin : SharedPreferences? = null

    @Inject
    lateinit var meetingRoomVM: MeetingRoomVM
    lateinit var adapterScheduleNow: AdapterScheduleNow
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meeting_room)

        (applicationContext as MyApplication).applicationComponent.inject(this)
        dataLogin = this.getSharedPreferences(
            getString(R.string.shared_preference_name),
            Context.MODE_PRIVATE
        )



        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.
            val msg = "Selected date is " + dayOfMonth + "/" + (month + 1) + "/" + year
            Toast.makeText(this@MeetingRoom, msg, Toast.LENGTH_SHORT).show()
        }

        scheduleRV.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        meetingRoomVM.schedule?.observe(this, androidx.lifecycle.Observer {
            adapterScheduleNow = AdapterScheduleNow(it,this)
            scheduleRV.adapter=adapterScheduleNow
            println("DATA SCHEDULE $adapterScheduleNow")

        })
        meetingRoomVM.now()

            fab_add_schedue.setOnClickListener {
                var dialog = AddSchedule()
                val bundle= Bundle()
                dialog.arguments = bundle

                bundle.putString("kode_doc", "KTP")


                dialog.show(supportFragmentManager, "customDialog")
            }
    }
}