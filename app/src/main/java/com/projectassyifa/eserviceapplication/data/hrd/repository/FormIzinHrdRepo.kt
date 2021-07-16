package com.projectassyifa.eserviceapplication.data.hrd.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.projectassyifa.eserviceapplication.data.hrd.api.FormIzinHrdAPI
import com.projectassyifa.eserviceapplication.data.hrd.model.FormIzinHrdModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FormIzinHrdRepo @Inject constructor(val formIzinHrdAPI: FormIzinHrdAPI) {
    var dataForm = MutableLiveData<ResponseAPI>()

    fun formIzin(formIzinHrdModel: FormIzinHrdModel){
        formIzinHrdAPI.formIzin(formIzinHrdModel).enqueue(object : Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val res = response?.body()
                val ResponseData = Gson().toJson(res)
                val FormIzinContent = Gson().fromJson<ResponseAPI>(ResponseData,ResponseAPI::class.java)
                dataForm.value = FormIzinContent
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("form izin failed connect")
            }

        })
    }
}