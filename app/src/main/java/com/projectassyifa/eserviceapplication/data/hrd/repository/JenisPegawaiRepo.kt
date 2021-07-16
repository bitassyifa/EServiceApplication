package com.projectassyifa.eserviceapplication.data.hrd.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.hrd.api.JenisPegawaiAPI
import com.projectassyifa.eserviceapplication.data.hrd.model.JenisPegawaiModel
import com.projectassyifa.eserviceapplication.data.hrd.model.StatusAktifModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject

class JenisPegawaiRepo @Inject constructor(val jenisPegawaiAPI: JenisPegawaiAPI) {

    var jns_pegawai : MutableLiveData<List<JenisPegawaiModel>> = MutableLiveData()

    fun jenisPegawai(id : String){
        jenisPegawaiAPI.jenisPegawai(id).enqueue(object : Callback<ResponseAPI> {
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {
                    println("DATA NULL")
                } else {
                    val gson = Gson()
                    val listKegiatan: Type = object : TypeToken<List<JenisPegawaiModel>?>() {}.type
                    val Output: List<JenisPegawaiModel> =
                        gson.fromJson(gson.toJson(res), listKegiatan)
                    jns_pegawai.value = Output

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