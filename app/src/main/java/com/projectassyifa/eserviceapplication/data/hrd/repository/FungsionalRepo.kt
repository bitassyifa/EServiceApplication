package com.projectassyifa.eserviceapplication.data.hrd.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.hrd.api.FungsionalAPI
import com.projectassyifa.eserviceapplication.data.hrd.model.FungsionalModel
import com.projectassyifa.eserviceapplication.data.hrd.model.JenisPegawaiModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject

class FungsionalRepo @Inject constructor(val fungsionalAPI: FungsionalAPI){
    var type_fungsi : MutableLiveData<List<FungsionalModel>> = MutableLiveData()

    fun fungsional(id : String ){
        fungsionalAPI.fungsional(id).enqueue(object : Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {
                    println("DATA NULL FUNGSIONAL")
                } else {
                    val gson = Gson()
                    val listKegiatan: Type = object : TypeToken<List<FungsionalModel>?>() {}.type
                    val Output: List<FungsionalModel> =
                        gson.fromJson(gson.toJson(res), listKegiatan)
                    type_fungsi.value = Output

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