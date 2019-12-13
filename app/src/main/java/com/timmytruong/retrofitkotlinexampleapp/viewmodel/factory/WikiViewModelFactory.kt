package com.timmytruong.retrofitkotlinexampleapp.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timmytruong.retrofitkotlinexampleapp.repository.WikiRepository
import com.timmytruong.retrofitkotlinexampleapp.viewmodel.WikiViewModel

class WikiViewModelFactory(private val wikiRepository: WikiRepository): ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WikiViewModel(wikiRepository) as T
    }

}