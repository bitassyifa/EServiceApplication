package com.projectassyifa.eserviceapplication.data.ruangrapat.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.data.ruangrapat.model.MeetingRoomModel
import com.projectassyifa.eserviceapplication.data.ruangrapat.viewmodel.MeetingRoomVM
import javax.inject.Inject

class AdapterScheduleNow (val listSchedule : List<MeetingRoomModel>,var activity: Activity)
    :RecyclerView.Adapter<ScheduleVH>(){

    @Inject
    lateinit var meetingRoomVM : MeetingRoomVM

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleVH {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_schedule_now,parent,false)
        return ScheduleVH(view)
    }

    override fun onBindViewHolder(holder: ScheduleVH, position: Int) {
       holder.jam_mulai.text = listSchedule[position].jam_mulai
        holder.jam_berlangsung.text = "${listSchedule[position].jam_mulai} s/d ${listSchedule[position].jam_selesai} "
        holder.title.text =listSchedule[position].keperluan
        holder.ruangan.text = listSchedule[position].peminjam
    }

    override fun getItemCount(): Int {
        return listSchedule.size
    }
}

class ScheduleVH (view: View) : RecyclerView.ViewHolder(view){
    var jam_mulai = view.findViewById<TextView>(R.id.jam_mulai)
    var title = view.findViewById<TextView>(R.id.title_rapat)
    var ruangan = view.findViewById<TextView>(R.id.ruangan)
    var jam_berlangsung = view.findViewById<TextView>(R.id.jam_berlangsung)

}
