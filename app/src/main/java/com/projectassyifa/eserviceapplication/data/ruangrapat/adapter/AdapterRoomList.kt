package com.projectassyifa.eserviceapplication.data.ruangrapat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.data.hrd.adapter.AdapterAlasanCuti
import com.projectassyifa.eserviceapplication.data.ruangrapat.model.ListRoomModel

class AdapterRoomList (val context: Context,var dataSource : List<ListRoomModel>) :BaseAdapter() {
private val     layoutInflate : LayoutInflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val vh : ListVH
        if (convertView == null){
            view = layoutInflate.inflate(R.layout.adapter_room_list,parent,false)
            vh = ListVH(view)
            view?.tag = vh
        } else {
            view = convertView
            vh =view.tag as ListVH
        }
        vh.list.text = dataSource.get(position).nama_ruangan
        return view
    }

    class ListVH(row: View?){
        val list : TextView
        init {
            list = row?.findViewById(R.id.list_room_meeting) as TextView
        }
    }
}
