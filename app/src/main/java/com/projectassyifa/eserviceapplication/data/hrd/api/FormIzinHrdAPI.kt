package com.projectassyifa.eserviceapplication.data.hrd.api

import com.projectassyifa.eserviceapplication.data.hrd.model.FormIzinHrdModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface FormIzinHrdAPI {

    @POST("izinFormHrd")
    fun formIzin(@Body formIzinHrdModel : FormIzinHrdModel):Call<ResponseAPI>
}