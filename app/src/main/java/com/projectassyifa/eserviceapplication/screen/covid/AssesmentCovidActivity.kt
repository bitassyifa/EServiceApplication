package com.projectassyifa.eserviceapplication.screen.covid

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.container.MyApplication
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.adapter.QuestionCovidAdapter
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.model.QuestionCovidModel
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.viewmodel.AnswerCovidVM
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.viewmodel.QuestionCovidVM
import com.projectassyifa.eserviceapplication.screen.home.HomeActivity
import kotlinx.android.synthetic.main.activity_assesment_covid.*
import javax.inject.Inject

class AssesmentCovidActivity : AppCompatActivity() {
    var dataLogin : SharedPreferences? = null
var list : List<QuestionCovidModel>? = null


    @Inject
    lateinit var questionCovidVM: QuestionCovidVM
    lateinit var questionCovidAdapter: QuestionCovidAdapter

    @Inject
    lateinit var answerCovidVM: AnswerCovidVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assesment_covid)
        (applicationContext as MyApplication).applicationComponent.inject(this)

        //tampil question
        QuestionView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        questionCovidVM.questionVM?.observe(this, Observer {
            questionCovidAdapter = QuestionCovidAdapter(it,this)

            QuestionView.adapter = questionCovidAdapter
            println("INI DATA ADAPTER $questionCovidAdapter")
        })

        questionCovidVM.question()

        btn_selesai.setOnClickListener {
            val move = Intent(this,HomeActivity::class.java)
            startActivity(move)
        }
        //add answer

    }
}