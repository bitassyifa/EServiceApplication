package com.projectassyifa.eserviceapplication.data.hrd.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.hrd.api.BerkasAPI
import com.projectassyifa.eserviceapplication.data.hrd.model.BerkasModel
import com.projectassyifa.eserviceapplication.data.hrd.model.StatusCutiModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject

class BerkasRepo @Inject constructor(val berkasAPI: BerkasAPI){
    var get_berkas : MutableLiveData<List<BerkasModel>> = MutableLiveData()

    fun berkas(id_pegawai : String,kode_doc:String){
        berkasAPI.berkas(id_pegawai, kode_doc).enqueue(object : Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {
                    println("DATA NULL berks")
                } else {
                    val gson = Gson()
                    val listData: Type = object : TypeToken<List<BerkasModel>?>() {}.type
                    val Output: List<BerkasModel> =
                        gson.fromJson(gson.toJson(res), listData)
                    get_berkas.value = Output

                    val responBody: ResponseBody? = null
                    responBody?.close()
                }
            }
            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("get berkas failed")
            }

        })
    }
}