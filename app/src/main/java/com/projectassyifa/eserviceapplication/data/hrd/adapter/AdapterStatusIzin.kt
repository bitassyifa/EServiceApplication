package com.projectassyifa.eserviceapplication.data.hrd.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.data.hrd.model.StatusIzinModel
import com.projectassyifa.eserviceapplication.data.hrd.viewmdoel.StatusIzinVM
import javax.inject.Inject

class AdapterStatusIzin (val listStatusIzin : List<StatusIzinModel>,var activity: Activity)
    :RecyclerView.Adapter<StatusizinVH>() {


    @Inject
    lateinit var statusIzinVM: StatusIzinVM

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusizinVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_status_izin,parent,false)

        return StatusizinVH(view)
    }

    override fun onBindViewHolder(holder: StatusizinVH, position: Int) {
        holder.status.text = listStatusIzin[position].status_cuti
        holder.tgl.text = listStatusIzin[position].tanggal
        holder.alibi.text = listStatusIzin[position].keperluan
        holder.bidang.text = listStatusIzin[position].bidang
        holder.atasan.text = listStatusIzin[position].atasan
    }

    override fun getItemCount(): Int {
       return listStatusIzin.size
    }

}

class StatusizinVH(view: View) : RecyclerView.ViewHolder(view){
    var status = view.findViewById<TextView>(R.id.stts_izin)
    var tgl = view.findViewById<TextView>(R.id.izin_tgl)
    var alibi = view.findViewById<TextView>(R.id.izin_keperluan)
    var bidang = view.findViewById<TextView>(R.id.izin_bidang)
    var atasan = view.findViewById<TextView>(R.id.izin_atasan)

}


