package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import com.projectassyifa.eserviceapplication.data.hrd.model.FormIzinHrdModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.FormIzinHrdRepo
import javax.inject.Inject

class FormIzinHrdVM @Inject constructor(var formIzinHrdRepo: FormIzinHrdRepo){
    fun formIzin(formIzinHrdModel: FormIzinHrdModel){
        formIzinHrdRepo.formIzin(formIzinHrdModel)
    }
}