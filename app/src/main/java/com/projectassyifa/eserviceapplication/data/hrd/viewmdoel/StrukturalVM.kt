package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.hrd.model.StrukturalModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.StrukturalRepo
import javax.inject.Inject

class StrukturalVM @Inject constructor(var strukturalRepo: StrukturalRepo){
    val type_struktural : MutableLiveData<List<StrukturalModel>>? = strukturalRepo.type_struktur

    fun struktur(id : String){
        strukturalRepo.struktur(id)
    }
}