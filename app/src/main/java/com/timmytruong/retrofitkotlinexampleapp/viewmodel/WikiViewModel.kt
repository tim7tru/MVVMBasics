package com.timmytruong.retrofitkotlinexampleapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timmytruong.retrofitkotlinexampleapp.model.Result
import com.timmytruong.retrofitkotlinexampleapp.model.SearchInfo
import com.timmytruong.retrofitkotlinexampleapp.model.WikiRequest
import com.timmytruong.retrofitkotlinexampleapp.repository.WikiRepository
import javax.inject.Inject

class WikiViewModel @Inject constructor(private val wikiRepository: WikiRepository) : ViewModel()
{
    private var wikiSearchInfoMutableLiveData: MutableLiveData<SearchInfo> = MutableLiveData()
    fun getWikiData(wikiRequest: WikiRequest)
    {
        wikiRepository.getWikiSearchInfoResponse(wikiRequest, wikiSearchInfoMutableLiveData)
    }

    fun getWikiResponse(): MutableLiveData<SearchInfo>?
    {
        return wikiSearchInfoMutableLiveData
    }
}