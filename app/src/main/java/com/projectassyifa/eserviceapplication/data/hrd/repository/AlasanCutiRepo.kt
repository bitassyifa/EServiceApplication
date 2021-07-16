package com.projectassyifa.eserviceapplication.data.hrd.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.hrd.api.AlasanCutiAPI
import com.projectassyifa.eserviceapplication.data.hrd.model.AlasanCutiModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

import javax.inject.Inject

class AlasanCutiRepo @Inject constructor(val alasanCutiAPI: AlasanCutiAPI) {
    var alibi : MutableLiveData<List<AlasanCutiModel>> = MutableLiveData()

    fun cuti(){
        alasanCutiAPI.cuti().enqueue(object :Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {
                    println("DATA NULL")
                } else {
                    val gson = Gson()
                    val listKegiatan: Type = object : TypeToken<List<AlasanCutiModel>?>() {}.type
                    val kegiatanOutputList: List<AlasanCutiModel> =
                        gson.fromJson(gson.toJson(res), listKegiatan)
                    alibi.value = kegiatanOutputList
                    val responBody: ResponseBody? = null


                    responBody?.close()
                }
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("gagal connect")
            }

        })
    }
}