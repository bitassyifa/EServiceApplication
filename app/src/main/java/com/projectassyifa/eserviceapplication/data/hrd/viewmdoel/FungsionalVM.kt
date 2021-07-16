package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.hrd.model.FungsionalModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.FungsionalRepo
import javax.inject.Inject

class FungsionalVM @Inject constructor(var fungsionalRepo: FungsionalRepo) {
    val type_fungsi :MutableLiveData<List<FungsionalModel>>? = fungsionalRepo.type_fungsi

    fun fungsional(id :  String){
        fungsionalRepo.fungsional(id)
    }
}