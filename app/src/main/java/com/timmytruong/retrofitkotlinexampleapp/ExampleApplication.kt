package com.timmytruong.retrofitkotlinexampleapp

import android.app.Application
import com.timmytruong.retrofitkotlinexampleapp.dagger.component.AppComponent
import com.timmytruong.retrofitkotlinexampleapp.dagger.component.DaggerAppComponent

class ExampleApplication: Application()
{
    private lateinit var appComponent: AppComponent

    override fun onCreate()
    {
        super.onCreate()
        createAppComponent()
    }

    private fun createAppComponent()
    {
        appComponent = DaggerAppComponent.builder().build()
    }
}