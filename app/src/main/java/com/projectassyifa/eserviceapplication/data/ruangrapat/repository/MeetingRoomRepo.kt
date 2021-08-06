package com.projectassyifa.eserviceapplication.data.ruangrapat.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.hrd.model.AlasanCutiModel
import com.projectassyifa.eserviceapplication.data.ruangrapat.api.MeetingRoomAPI
import com.projectassyifa.eserviceapplication.data.ruangrapat.model.MeetingRoomModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject

class MeetingRoomRepo @Inject constructor(val meetingRoomAPI: MeetingRoomAPI) {
    var schedule : MutableLiveData<List<MeetingRoomModel>> = MutableLiveData()
    var data_schedule = MutableLiveData<ResponseAPI>()
    fun now(){
        meetingRoomAPI.now().enqueue(object :Callback<ResponseAPI>{
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {
                    println("DATA NULL")
                } else {
                    val gson = Gson()
                    val listKegiatan: Type = object : TypeToken<List<MeetingRoomModel>?>() {}.type
                    val kegiatanOutputList: List<MeetingRoomModel> =
                        gson.fromJson(gson.toJson(res), listKegiatan)
                   schedule.value = kegiatanOutputList
                    val responBody: ResponseBody? = null


                    responBody?.close()
                }
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("gagal connect schedule now")
            }

        })
    }

    fun add_schedule(meetingRoomModel: MeetingRoomModel){
        meetingRoomAPI.add_schedule(meetingRoomModel).enqueue(object : Callback<ResponseAPI> {
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val res = response?.body()
                val ResponseData = Gson().toJson(res)
                val content = Gson().fromJson<ResponseAPI>(ResponseData,ResponseAPI::class.java)
                data_schedule.value = content
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("form izin failed connect")
            }

        })
    }
}