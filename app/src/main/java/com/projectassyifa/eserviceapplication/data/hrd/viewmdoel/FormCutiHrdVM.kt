package com.projectassyifa.eserviceapplication.data.hrd.viewmdoel

import com.projectassyifa.eserviceapplication.data.hrd.model.FormCutiHrdModel
import com.projectassyifa.eserviceapplication.data.hrd.repository.FormCutiHrdRepo
import javax.inject.Inject

class FormCutiHrdVM @Inject constructor(var formCutiHrdRepo: FormCutiHrdRepo){
    fun formCuti(formCutiHrdModel: FormCutiHrdModel){
        formCutiHrdRepo.formCuti(formCutiHrdModel)
    }
}