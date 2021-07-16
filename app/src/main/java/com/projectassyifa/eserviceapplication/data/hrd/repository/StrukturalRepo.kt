package com.projectassyifa.eserviceapplication.data.hrd.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.hrd.api.StrukturalAPI
import com.projectassyifa.eserviceapplication.data.hrd.model.FungsionalModel
import com.projectassyifa.eserviceapplication.data.hrd.model.StrukturalModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject

class StrukturalRepo @Inject constructor(val strukturalAPI: StrukturalAPI){
    var type_struktur : MutableLiveData<List<StrukturalModel>> = MutableLiveData()

    fun struktur(id : String){
        strukturalAPI.struktur(id).enqueue(object : Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {
                    println("DATA NULL STRUKTURAL")
                } else {
                    val gson = Gson()
                    val listKegiatan: Type = object : TypeToken<List<StrukturalModel>?>() {}.type
                    val Output: List<StrukturalModel> =
                        gson.fromJson(gson.toJson(res), listKegiatan)
                    type_struktur.value = Output

                    val responBody: ResponseBody? = null
                    responBody?.close()

                }
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
            }

        })
    }
}