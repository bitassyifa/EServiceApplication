package com.projectassyifa.eserviceapplication.data.hrd.api

import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StrukturalAPI {
    @GET("struktural/{id}")
    fun struktur(@Path("id")id : String ):Call<ResponseAPI>
}