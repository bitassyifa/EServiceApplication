package com.projectassyifa.eserviceapplication.data.hrd.api

import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JenisPegawaiAPI {
    @GET("statusPegawai/{id}")
    fun jenisPegawai(@Path("id")id:String):Call<ResponseAPI>
}