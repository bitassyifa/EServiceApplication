package com.projectassyifa.eserviceapplication.data.hrd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.data.hrd.model.AlasanCutiModel
import com.projectassyifa.eserviceapplication.data.hrd.model.AlasanIzinModel

class AdapterAlasanIzin  (val context: Context, var dataSource :List<AlasanIzinModel>): BaseAdapter(){

    private val  inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return  dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val vh : ItemHolder

        if (convertView == null ){
            view = inflater.inflate(R.layout.adapter_alasancuti,parent,false)
            vh=ItemHolder(view)
            view?.tag =vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.cutiAlasan.text = "${dataSource.get(position).nama})"
        return view
    }

    private class ItemHolder(row: View?) {
        //        val id: TextView
        val cutiAlasan: TextView
        init {
            cutiAlasan = row?.findViewById(R.id.alibicuti) as TextView
        }
    }

}