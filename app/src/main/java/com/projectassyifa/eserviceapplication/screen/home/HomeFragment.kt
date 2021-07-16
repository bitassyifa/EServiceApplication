package com.projectassyifa.eserviceapplication.screen.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.projectassyifa.eserviceapplication.R
import com.projectassyifa.eserviceapplication.screen.covid.AssesmentCovidActivity
import com.projectassyifa.eserviceapplication.screen.health.HealthCareEmployee
import com.projectassyifa.eserviceapplication.screen.hrd.HrdActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profil_user.*

class HomeFragment : Fragment() {

    var dataLogin: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataLogin = activity?.getSharedPreferences(
            getString(R.string.shared_preference_name),
            Context.MODE_PRIVATE
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menu1.setOnClickListener {
            val move = Intent(this.context,HealthCareEmployee::class.java)
            startActivity(move)
        }
        menu2.setOnClickListener {
            val move = Intent(this.context,AssesmentCovidActivity::class.java)
            startActivity(move)
        }
        menu4.setOnClickListener {
            val move = Intent(this.context,HrdActivity::class.java)
            startActivity(move)
        }

        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel(R.drawable.s1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.s2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.s3, ScaleTypes.FIT))

        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)
        val nama = dataLogin?.getString(
            getString(R.string.nama_pegawai),
            getString(R.string.default_value)
        )

        ahlan.text ="Ahlan, $nama"

        val foto = dataLogin?.getString(
            getString(R.string.foto),
            getString(R.string.default_value)
        )
        var linkFoto= "http://202.62.9.138:1234/hrd/php/foto/$foto"
        Glide
            .with(this)
            .load(linkFoto)
            .fitCenter()
            .placeholder(R.drawable.ic_profil)
            .into(profil_image1);
    }

}