package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.hrd.model.AlasanCutiModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.AlasanCutiRepo
import javax.inject.Inject

class AlasanCutiVM @Inject constructor(var alasanCutiRepo: AlasanCutiRepo){
    var alibi : MutableLiveData<List<AlasanCutiModel>>? = alasanCutiRepo.alibi

    fun cuti(){
        alasanCutiRepo.cuti()
    }
}