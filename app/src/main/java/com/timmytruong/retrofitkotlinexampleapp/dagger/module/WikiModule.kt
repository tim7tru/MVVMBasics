package com.timmytruong.retrofitkotlinexampleapp.dagger.module

import com.timmytruong.retrofitkotlinexampleapp.interfaces.WikiService
import com.timmytruong.retrofitkotlinexampleapp.mapper.WikiMapper
import com.timmytruong.retrofitkotlinexampleapp.repository.WikiRepository
import com.timmytruong.retrofitkotlinexampleapp.utils.AppConstants
import com.timmytruong.retrofitkotlinexampleapp.viewmodel.factory.WikiViewModelFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class WikiModule
{
    @Singleton
    @Provides
    fun providesWikiService(httpClient: OkHttpClient): WikiService
    {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .baseUrl(AppConstants.WIKI_BASE_URL)
            .build()
            .create(WikiService::class.java)
    }

    @Singleton
    @Provides
    fun providesWikiViewModelFactory(wikiRepository: WikiRepository): WikiViewModelFactory
    {
        return WikiViewModelFactory(wikiRepository)
    }

    @Provides
    @Singleton
    fun providesWikiMapper(): WikiMapper
    {
        return WikiMapper()
    }

    @Singleton
    @Provides
    fun providesWikiRepository(wikiService: WikiService, wikiMapper: WikiMapper): WikiRepository
    {
        return WikiRepository(wikiService, wikiMapper)
    }
}