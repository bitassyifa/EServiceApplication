package com.projectassyifa.eserviceapplication.data.pegawai.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.pegawai.api.EmployeeAPI
import com.projectassyifa.eserviceapplication.data.pegawai.model.EmployeeModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject

class EmployeeRepo @Inject constructor(val employeeAPI: EmployeeAPI) {
    var data : MutableLiveData<List<EmployeeModel>> = MutableLiveData()

    fun employee(){
        employeeAPI.employee().enqueue(object :Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {
                    println("nama file null")
                } else {
                    val gson = Gson()
                    val listEmployee : Type = object : TypeToken<List<EmployeeModel>?>() {}.type
                    val employeeOutputList : List<EmployeeModel> = gson.fromJson(gson.toJson(res),listEmployee)

                    data.value = employeeOutputList

                }
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("gagal connect")
            }

        })
    }
}