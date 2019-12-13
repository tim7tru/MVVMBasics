package com.timmytruong.retrofitkotlinexampleapp.mapper

import android.util.Log
import com.timmytruong.retrofitkotlinexampleapp.model.Result
import com.timmytruong.retrofitkotlinexampleapp.model.SearchInfo
import com.timmytruong.retrofitkotlinexampleapp.model.WikiRequest
import retrofit2.Response
import javax.inject.Inject

class WikiMapper @Inject constructor()
{
    fun getWikiRequest(searchString: String): WikiRequest
    {
        return WikiRequest(searchString = searchString)
    }

    fun processSearchInfoResponse(result: Result): SearchInfo
    {
        return result.query.searchinfo
    }
}