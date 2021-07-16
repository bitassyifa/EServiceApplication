package com.projectassyifa.eserviceapplication.data.login.api


import com.projectassyifa.eserviceapplication.data.login.model.UserLoginModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserLoginAPI {
    @POST("hrd/api/")
    fun loginUser(@Body userLoginModel : UserLoginModel):Call<ResponseAPI>
}