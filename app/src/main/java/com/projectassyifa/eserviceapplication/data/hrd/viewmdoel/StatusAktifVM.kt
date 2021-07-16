package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.hrd.model.StatusAktifModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.StatusAktifRepo
import javax.inject.Inject

class StatusAktifVM @Inject constructor(var statusAktifRepo: StatusAktifRepo){

    val sts_pegawai : MutableLiveData<List<StatusAktifModel>>? = statusAktifRepo.sts_pegawai
    fun statusPegawai(id:String){
        statusAktifRepo.statusPegawai(id)
    }

}