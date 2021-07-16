package com.projectassyifa.eserviceapplication.data.assesmentCovid19.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.api.QuestionCovidAPI
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.model.AnswerCovidModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AnswerCovidRepo @Inject constructor(val questionCovidAPI: QuestionCovidAPI) {

    var answerCovid = MutableLiveData<ResponseAPI>()

    fun answer(answerCovidModel: AnswerCovidModel){
        questionCovidAPI.answer(answerCovidModel).enqueue(object : Callback<ResponseAPI> {
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val res = response?.body()
                val ResponseData = Gson().toJson(res)
                val TypeActivityResponse = Gson().fromJson<ResponseAPI>(ResponseData,ResponseAPI::class.java)
                answerCovid.value = TypeActivityResponse
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("gagal")
            }

        })
    }
}