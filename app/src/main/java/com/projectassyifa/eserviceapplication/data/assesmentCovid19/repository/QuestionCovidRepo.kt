package com.projectassyifa.eserviceapplication.data.assesmentCovid19.repository

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.api.QuestionCovidAPI
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.model.QuestionCovidModel
import com.projectassyifa.eserviceapplication.utils.ResponseAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import javax.inject.Inject

class QuestionCovidRepo @Inject constructor(val questionCovidAPI: QuestionCovidAPI) {
    var questionCovid : MutableLiveData<List<QuestionCovidModel>> = MutableLiveData()

    fun question(){
        questionCovidAPI.question().enqueue(object : Callback<ResponseAPI> {
            override fun onResponse(call: Call<ResponseAPI>, response: Response<ResponseAPI>) {
                val responData = response.body()
                val res = responData?.data
                if (res == null) {

                } else {
                    val gson = Gson()
                    val listKegiatan: Type = object : TypeToken<List<QuestionCovidModel>?>() {}.type
                    val kegiatanOutputList: List<QuestionCovidModel> =
                        gson.fromJson(gson.toJson(res), listKegiatan)
                    questionCovid.value = kegiatanOutputList

                    val responBody : ResponseBody? = null


                    responBody?.close()
                    println("reponse $res")
                    println("output $kegiatanOutputList")
                }
            }

            override fun onFailure(call: Call<ResponseAPI>, t: Throwable) {
                println(t.localizedMessage)
                println("gagal")
            }

        })
    }
}