package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.hrd.model.JenisPegawaiModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.JenisPegawaiRepo
import javax.inject.Inject

class JenisPegawaiVM @Inject constructor(var jenisPegawaiRepo: JenisPegawaiRepo) {
    val jns_pegawai : MutableLiveData<List<JenisPegawaiModel>>? = jenisPegawaiRepo.jns_pegawai

    fun jenisPegawai(id : String){
        jenisPegawaiRepo.jenisPegawai(id)
    }
}