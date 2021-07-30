package com.projectassyifa.eserviceapplication.screen.hrd.statusizincuti

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.container.MyApplication
import com.projectassyifa.eserviceapplication.data.hrd.adapter.AdapterStatusCuti
import com.projectassyifa.eserviceapplication.data.hrd.adapter.AdapterStatusIzin
import com.projectassyifa.eserviceapplication.data.hrd.viewmdoel.StatusCutiVM
import kotlinx.android.synthetic.main.fragment_status_cuti_page.*
import kotlinx.android.synthetic.main.fragment_status_izin_page.*
import kotlinx.android.synthetic.main.fragment_status_izin_page.statusizinRV
import javax.inject.Inject

class StatusCutiPage : Fragment() {

    var dataLogin: SharedPreferences? = null

    @Inject
    lateinit var statusCutiVM: StatusCutiVM
    lateinit var adapterStatusCuti : AdapterStatusCuti

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
        return inflater.inflate(R.layout.fragment_status_cuti_page, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id_pegawai= dataLogin?.getString(
            getString(R.string.id_pegawai),
            getString(R.string.default_value)
        )

        statuscutiRV.layoutManager= LinearLayoutManager(this.context, RecyclerView.VERTICAL,false)
        statusCutiVM.status_cuti?.observe(viewLifecycleOwner, Observer {
            adapterStatusCuti= activity?.let { it1 -> AdapterStatusCuti(it, it1) }!!
            statuscutiRV.adapter = adapterStatusCuti
            println("INI ADAPTER $adapterStatusCuti")
        })
        statusCutiVM.statusCuti(id_pegawai.toString())

    }


}