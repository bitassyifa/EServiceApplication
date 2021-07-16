package com.projectassyifa.eserviceapplication.data.assesmentCovid19.adapter

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.container.MyApplication
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.model.AnswerCovidModel
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.model.QuestionCovidModel
import com.projectassyifa.eserviceapplication.data.assesmentCovid19.viewmodel.AnswerCovidVM
import com.projectassyifa.eserviceapplication.screen.covid.AssesmentCovidActivity
import javax.inject.Inject


class QuestionCovidAdapter (val listQuestion : List<QuestionCovidModel>,var activity : Activity)
    : RecyclerView.Adapter<QuestionViewHolder>()
        {
            var choice : String? = null

            var dataLogin : SharedPreferences? = null

            @Inject
            lateinit var answerCovidVM: AnswerCovidVM

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_question_covid,parent,false)
                (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
//                dataLogin = view.getContext().getSharedPreferences(R.string.shared_preference_name.toString(), Context.MODE_PRIVATE)
                dataLogin = activity?.getSharedPreferences(
                    activity.getString(R.string.shared_preference_name),
                    Context.MODE_PRIVATE
                )
                return QuestionViewHolder(view)
            }

            override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
                holder.id.text = listQuestion[position].id_pertanyaan
                holder.question.text = listQuestion[position].pertanyaan

                holder.answer.setOnCheckedChangeListener { group, checkedId ->
                    var rb: RadioButton = group.findViewById<RadioButton>(checkedId)
                    if (rb != null) {
                        choice = rb.text.toString()
//                        println(listQuestion[position].pertanyaan)
//                        println(choice)

                        // Initialize a new instance of
                        val builder = AlertDialog.Builder(activity)

                        // Set the alert dialog title
                        builder.setTitle("Apakah anda yakin dengan jawaban anda?")

                        // Display a message on alert dialog
                        builder.setMessage("Pertanyaan "+listQuestion[position].pertanyaan +", dan jawabanya "+choice)

                        // Set a positive button and its click listener on alert dialog
                        builder.setPositiveButton("Yakin"){dialog, which ->
                            // Do something when user press the positive button


                            Toast.makeText(activity,"Data berhasil disimpan.",Toast.LENGTH_SHORT).show()

                            // save db
                            val id_pegawai= dataLogin?.getString(
                                activity.getString(R.string.id_pegawai),
                                activity.getString(R.string.default_value)
                            )

                            val nama_pegawai= dataLogin?.getString(
                                activity.getString(R.string.nama_pegawai),
                                activity.getString(R.string.default_value)
                            )

                            val bidang= dataLogin?.getString(
                                activity.getString(R.string.bidang),
                                activity.getString(R.string.default_value)
                            )

                            val unit= dataLogin?.getString(
                                activity.getString(R.string.unit),
                                activity.getString(R.string.default_value)
                            )

                            val username= dataLogin?.getString(
                                activity.getString(R.string.username),
                                activity.getString(R.string.default_value)
                            )

                            var id_pertanyaan = listQuestion[position].id_pertanyaan
                            var pertanyaan = listQuestion[position].pertanyaan
                            var jawaban = choice

//                            println("ID Pegawai $id_pegawai")
//                            println("Nama Pegawai $nama_pegawai")
//                            println("Bidang $bidang")
//                            println("Unit $unit")
//                            println("username $username")
//                            println("ID Pertnyaan $id_pertanyaan")
//                            println("pertanyaan $pertanyaan")
//                            println("Jawaban $jawaban")

                            val content = AnswerCovidModel(
                                id_pegawai = id_pegawai.toString(),
                                nama_pegawai = nama_pegawai.toString(),
                                bidang = bidang.toString(),
                                unit = unit.toString(),
                                id_pertanyaan = id_pertanyaan,
                                pertanyaan = pertanyaan,
                                jawaban = jawaban.toString(),
                                created_by = username.toString()
                            )
                            answerCovidVM.answer(content)

                        }


                        // Display a negative button on alert dialog
                        builder.setNegativeButton("Tidak Yakin"){dialog,which ->
                            Toast.makeText(activity,"Anda tidak yakin.",Toast.LENGTH_SHORT).show()
                        }


                        // Display a neutral button on alert dialog
//                        builder.setNeutralButton("Cancel"){_,_ ->
//                            Toast.makeText(activity,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
//                        }

                        // Finally, make the alert dialog using builder
                        val dialog: AlertDialog = builder.create()

                        // Display the alert dialog on app interface
                        dialog.show()

                    }
                }
            }

            override fun getItemCount(): Int {
                return listQuestion.size
            }

        }



class QuestionViewHolder (v: View) :RecyclerView.ViewHolder(v){
        var id =  v.findViewById<TextView>(R.id.id_pertaanyaan)
        var question = v.findViewById<TextView>(R.id.pertanyaan)
        var answer = v.findViewById<RadioGroup>(R.id.jawaban)
//        var rb = v.findViewById<RadioButton>()
}
