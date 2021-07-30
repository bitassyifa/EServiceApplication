package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.hrd.model.StatusCutiModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.StatusCutiRepo
import javax.inject.Inject

class StatusCutiVM @Inject constructor(var statusCutiRepo: StatusCutiRepo){
    val status_cuti : MutableLiveData<List<StatusCutiModel>>? = statusCutiRepo.status_cuti

    fun statusCuti(id_pegawai : String){
        statusCutiRepo.statusCuti(id_pegawai)
    }
}