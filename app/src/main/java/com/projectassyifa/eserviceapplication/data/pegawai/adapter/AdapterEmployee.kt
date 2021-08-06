package com.projectassyifa.eserviceapplication.data.pegawai.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.data.pegawai.model.EmployeeModel

class AdapterEmployee (var dataSource : List<EmployeeModel>,val context: Context) :BaseAdapter() {
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
        if (convertView == null) {
            view = inflater.inflate(R.layout.adapter_room_list,parent,false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.list.text = dataSource.get(position).nama_pegawai
        return view
    }

    class ItemHolder(view: View) {
        val list : TextView
        init {
            list = view?.findViewById(R.id.list_room_meeting) as TextView
        }
    }

}