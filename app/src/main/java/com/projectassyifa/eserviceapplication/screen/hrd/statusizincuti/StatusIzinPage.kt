package com.projectassyifa.eserviceapplication.screen.hrd.statusizincuti

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.container.MyApplication
import com.projectassyifa.eserviceapplication.data.hrd.adapter.AdapterStatusIzin
import com.projectassyifa.eserviceapplication.data.hrd.viewmdoel.StatusIzinVM
import kotlinx.android.synthetic.main.fragment_status_izin_page.*
import javax.inject.Inject


class StatusIzinPage : Fragment() {

    var dataLogin: SharedPreferences? = null

    @Inject
    lateinit var statusIzinVM: StatusIzinVM
    lateinit var adapterStatusIzin: AdapterStatusIzin


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
        dataLogin = activity?.getSharedPreferences(
            getString(R.string.shared_preference_name),
            Context.MODE_PRIVATE
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status_izin_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id_pegawai= dataLogin?.getString(
            getString(R.string.id_pegawai),
            getString(R.string.default_value)
        )

        statusizinRV.layoutManager=LinearLayoutManager(this.context,RecyclerView.VERTICAL,false)
        statusIzinVM.status_izin?.observe(viewLifecycleOwner, Observer {
            adapterStatusIzin = activity?.let { it1 -> AdapterStatusIzin(it, it1) }!!
            statusizinRV.adapter = adapterStatusIzin
            println("DATA ADAPTER IZIN $adapterStatusIzin")
        })
        statusIzinVM.statusIzin(id_pegawai.toString())

    }


}