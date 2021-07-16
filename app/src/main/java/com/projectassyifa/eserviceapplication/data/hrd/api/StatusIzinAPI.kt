package com.projectassyifa.eserviceapplication.data.hrd.api

import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StatusIzinAPI {
    @GET("statusIzin/{id_pegawai}")
    fun statusIzin(@Path("id_pegawai")id_pegawai : String ):Call<ResponseAPI>
}