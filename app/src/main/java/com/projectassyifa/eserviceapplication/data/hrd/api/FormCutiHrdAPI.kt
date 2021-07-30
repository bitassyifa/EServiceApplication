package com.projectassyifa.eserviceapplication.data.hrd.api

import com.projectassyifa.eserviceapplication.data.hrd.model.FormCutiHrdModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface FormCutiHrdAPI {
    @POST("cutiFormHrd")
    fun formCuti(@Body formCutiHrdModel : FormCutiHrdModel):Call<ResponseAPI>
}