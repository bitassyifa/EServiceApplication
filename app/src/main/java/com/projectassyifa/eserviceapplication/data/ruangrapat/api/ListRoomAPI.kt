package com.projectassyifa.eserviceapplication.data.ruangrapat.api

import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET

interface ListRoomAPI {
    @GET("meetingRoomList")
    fun room():Call<ResponseAPI>
}