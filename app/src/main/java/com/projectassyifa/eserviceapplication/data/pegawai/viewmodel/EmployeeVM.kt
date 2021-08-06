package com.projectassyifa.eserviceapplication.data.pegawai.viewmodel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.pegawai.model.EmployeeModel
import com.projectassyifa.eserviceapplication.data.pegawai.repository.EmployeeRepo
import javax.inject.Inject

class EmployeeVM @Inject constructor(val employeeRepo: EmployeeRepo){
    val data_employee : MutableLiveData<List<EmployeeModel>>? = employeeRepo.data

    fun employee(){
        employeeRepo.employee()
    }
}