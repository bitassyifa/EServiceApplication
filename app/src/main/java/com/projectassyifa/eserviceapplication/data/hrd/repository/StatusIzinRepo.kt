package com.projectassyifa.eserviceapplication.data.hrd.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.hrd.api.StatusIzinAPI
import com.projectassyifa.eserviceapplication.data.hrd.model.FungsionalModel
import com.projectassyifa.eserviceapplication.data.hrd.model.StatusIzinModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject

class StatusIzinRepo @Inject constructor(val statusIzinAPI: StatusIzinAPI) {
    var status_izin : MutableLiveData<List<StatusIzinModel>> = MutableLiveData()

    fun statusIzin(id_pegawai : String ){
        statusIzinAPI.statusIzin(id_pegawai).enqueue(object  : Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {
                    println("DATA NULL STATUS IZIN")
                } else {
                    val gson = Gson()
                    val listData: Type = object : TypeToken<List<StatusIzinModel>?>() {}.type
                    val Output: List<StatusIzinModel> =
                        gson.fromJson(gson.toJson(res), listData)
                    status_izin.value = Output

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