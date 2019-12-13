package com.timmytruong.retrofitkotlinexampleapp.dagger.component

import com.timmytruong.retrofitkotlinexampleapp.activity.MainActivity
import com.timmytruong.retrofitkotlinexampleapp.dagger.module.HttpModule
import com.timmytruong.retrofitkotlinexampleapp.dagger.module.WikiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HttpModule::class, WikiModule::class])
interface AppComponent
{
    fun inject(mainActivity: MainActivity)
}