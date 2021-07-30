package com.projectassyifa.eserviceapplication.data.hrd.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.data.hrd.model.StatusCutiModel
import com.projectassyifa.eserviceapplication.data.hrd.viewmdoel.StatusCutiVM
import javax.inject.Inject

class AdapterStatusCuti (val listStatusCuti : List<StatusCutiModel>,var activity: Activity)
    : RecyclerView.Adapter<StatusCutiVH>(){

    @Inject
    lateinit var statusCutiVM :StatusCutiVM


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusCutiVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_status_izin,parent,false)

        return StatusCutiVH(view)
    }

    override fun onBindViewHolder(holder: StatusCutiVH, position: Int) {
        holder.status.text = listStatusCuti[position].status_cuti
        holder.tgl.text = listStatusCuti[position].tanggal
        holder.alibi.text = listStatusCuti[position].keperluan
        holder.bidang.text = listStatusCuti[position].bidang
        holder.atasan.text = listStatusCuti[position].atasan
    }

    override fun getItemCount(): Int {
        return listStatusCuti.size
    }

}

class StatusCutiVH (view: View) : RecyclerView.ViewHolder(view){
    var status = view.findViewById<TextView>(R.id.stts_izin)
    var tgl = view.findViewById<TextView>(R.id.izin_tgl)
    var alibi = view.findViewById<TextView>(R.id.izin_keperluan)
    var bidang = view.findViewById<TextView>(R.id.izin_bidang)
    var atasan = view.findViewById<TextView>(R.id.izin_atasan)
}
