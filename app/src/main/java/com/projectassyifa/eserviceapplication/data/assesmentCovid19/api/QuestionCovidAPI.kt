package com.projectassyifa.eserviceapplication.data.assesmentCovid19.api

import com.projectassyifa.eserviceapplication.data.assesmentCovid19.model.AnswerCovidModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface QuestionCovidAPI {
    @GET("questionCovid")
    fun question() :Call<ResponseAPI>

    @POST("questionCovid")
    fun answer(@Body answerCovidModel : AnswerCovidModel) :Call<ResponseAPI>

}