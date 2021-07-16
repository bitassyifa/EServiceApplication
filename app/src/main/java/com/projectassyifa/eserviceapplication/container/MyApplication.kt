package com.projectassyifa.eserviceapplication.container

import android.app.Application

class MyApplication :Application() {
    val applicationComponent : ApplicationComponent = DaggerApplicationComponent.create()
}