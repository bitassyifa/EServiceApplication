package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.hrd.model.StatusIzinModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.StatusIzinRepo
import javax.inject.Inject

class StatusIzinVM @Inject constructor(var statusIzinRepo: StatusIzinRepo) {
    val status_izin : MutableLiveData<List<StatusIzinModel>>? = statusIzinRepo.status_izin
    fun statusIzin(id_pegawai: String){
        statusIzinRepo.statusIzin(id_pegawai)
    }
}