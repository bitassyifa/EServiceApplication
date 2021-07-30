package com.projectassyifa.eserviceapplication.data.hrd.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.projectassyifa.eserviceapplication.data.hrd.api.FormCutiHrdAPI
import com.projectassyifa.eserviceapplication.data.hrd.model.FormCutiHrdModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FormCutiHrdRepo @Inject constructor(val formCutiHrdAPI: FormCutiHrdAPI) {
    var dataForm = MutableLiveData<ResponseAPI>()

    fun formCuti(formCutiHrdModel: FormCutiHrdModel){
        formCutiHrdAPI.formCuti(formCutiHrdModel).enqueue(object : Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val res = response?.body()
                val ResponseData = Gson().toJson(res)
                val FormIzinContent = Gson().fromJson<ResponseAPI>(ResponseData,ResponseAPI::class.java)
                dataForm.value = FormIzinContent
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("form cuti failed connect")
            }

        })
    }
}