package com.timmytruong.retrofitkotlinexampleapp.dagger.module

import com.timmytruong.retrofitkotlinexampleapp.utils.AppConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class HttpModule
{
    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient
    {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(AppConstants.TIME_CONNECT_IN_SECONDS, TimeUnit.SECONDS)
            .readTimeout(AppConstants.TIME_READ_IN_SECONDS, TimeUnit.SECONDS)
            .build()
    }
}