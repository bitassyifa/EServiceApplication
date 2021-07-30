package com.projectassyifa.eserviceapplication.data.hrd.api

import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET

interface AlasanIzinAPI {
    @GET("alasanIzin")
    fun izin():Call<ResponseAPI>
}