package com.timmytruong.retrofitkotlinexampleapp.repository

import androidx.lifecycle.MutableLiveData
import com.timmytruong.retrofitkotlinexampleapp.interfaces.WikiService
import com.timmytruong.retrofitkotlinexampleapp.mapper.WikiMapper
import com.timmytruong.retrofitkotlinexampleapp.model.Result
import com.timmytruong.retrofitkotlinexampleapp.model.SearchInfo
import com.timmytruong.retrofitkotlinexampleapp.model.WikiRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WikiRepository @Inject constructor(private val wikiService: WikiService,
                                         private val wikiMapper: WikiMapper)
{
    private var wikiResponseCall: Call<Result>? = null

    fun getWikiSearchInfoResponse(wikiRequest: WikiRequest, wikiSearchInfoMutableLiveData: MutableLiveData<SearchInfo>)
    {
        wikiResponseCall = wikiService.getCount("query","json","search", wikiRequest.searchString)
        wikiResponseCall!!.enqueue(
            object: Callback<Result> {
                override fun onResponse(call: Call<Result>, response: Response<Result>)
                {
                    if (response.isSuccessful && response.body() != null)
                    {
                        wikiSearchInfoMutableLiveData.postValue(wikiMapper.processSearchInfoResponse(response.body()!!))
                    }
                }

                override fun onFailure(call: Call<Result>, t: Throwable)
                {
                    wikiSearchInfoMutableLiveData.postValue(SearchInfo(0))
                }
            })
    }
}