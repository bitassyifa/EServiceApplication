package com.projectassyifa.eserviceapplication.data.ruangrapat.api

import com.projectassyifa.eserviceapplication.data.ruangrapat.model.MeetingRoomModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MeetingRoomAPI {
    @GET("schedule_meeting")
    fun now(): Call<ResponseAPI>

    @POST("schedule_meeting")
    fun add_schedule(@Body meetingRoomModel: MeetingRoomModel):Call<ResponseAPI>
}
