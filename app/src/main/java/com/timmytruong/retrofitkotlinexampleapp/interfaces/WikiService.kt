package com.timmytruong.retrofitkotlinexampleapp.interfaces

import com.timmytruong.retrofitkotlinexampleapp.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiService
{
    @GET("api.php")
    fun getCount(@Query("action") action: String,
                 @Query("format") format: String,
                 @Query("list") list: String,
                 @Query("srsearch") srsearch: String): Call<Result>
}