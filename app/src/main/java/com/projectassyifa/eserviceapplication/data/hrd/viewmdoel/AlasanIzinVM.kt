package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.hrd.model.AlasanIzinModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.AlasanIzinRepo
import javax.inject.Inject

class AlasanIzinVM @Inject constructor(var alasanIzinRepo: AlasanIzinRepo) {
    var alibi_izin :MutableLiveData<List<AlasanIzinModel>>? = alasanIzinRepo.alibi_izin

    fun izin(){
        alasanIzinRepo.izin()
    }
}