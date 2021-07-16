package com.projectassyifa.eserviceapplication.data.hrd.api

import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Path


interface StatusAktifAPI {
    @GET("statusAktif/{id}")
    fun statusPegawai(@Path("id")id : String): Call<ResponseAPI>

}