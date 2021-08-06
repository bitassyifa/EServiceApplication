package com.projectassyifa.eserviceapplication.data.ruangrapat.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.ruangrapat.api.ListRoomAPI
import com.projectassyifa.eserviceapplication.data.ruangrapat.model.ListRoomModel
import com.projectassyifa.eserviceapplication.data.ruangrapat.model.MeetingRoomModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject

class ListRoomRepo @Inject constructor(val listRoomAPI : ListRoomAPI) {
    var listRoom : MutableLiveData<List<ListRoomModel>> = MutableLiveData()

    fun room(){
        listRoomAPI.room().enqueue(object :Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {
                    println("DATA NULL")
                } else {
                    val gson = Gson()
                    val listKegiatan: Type = object : TypeToken<List<ListRoomModel>?>() {}.type
                    val OutputList: List<ListRoomModel> =
                        gson.fromJson(gson.toJson(res), listKegiatan)
                    listRoom.value = OutputList
                    val responBody: ResponseBody? = null


                    responBody?.close()
                }
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("gagal connect list room")
            }

        })
    }
}