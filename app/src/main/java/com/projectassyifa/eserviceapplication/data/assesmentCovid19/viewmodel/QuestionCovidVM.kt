package com.projectassyifa.eserviceapplication.data.assesmentCovid19.viewmodel

import androidx.lifecycle.MutableLiveData
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.model.QuestionCovidModel
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.repository.QuestionCovidRepo
import javax.inject.Inject

class QuestionCovidVM @Inject constructor(var questionCovidRepo: QuestionCovidRepo){
    val questionVM : MutableLiveData<List<QuestionCovidModel>>? = questionCovidRepo.questionCovid
    fun question(){
        questionCovidRepo.question()
    }
}