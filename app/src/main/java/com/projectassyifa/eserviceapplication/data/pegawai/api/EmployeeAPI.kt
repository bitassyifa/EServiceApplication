package com.projectassyifa.eserviceapplication.data.pegawai.api

import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeAPI {
    @GET("employee")
    fun employee(): Call<ResponseAPI>
}