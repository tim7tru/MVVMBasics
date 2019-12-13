package com.timmytruong.retrofitkotlinexampleapp.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.timmytruong.retrofitkotlinexampleapp.R
import com.timmytruong.retrofitkotlinexampleapp.dagger.component.DaggerAppComponent
import com.timmytruong.retrofitkotlinexampleapp.mapper.WikiMapper
import com.timmytruong.retrofitkotlinexampleapp.model.SearchInfo
import com.timmytruong.retrofitkotlinexampleapp.utils.CommonUtils
import com.timmytruong.retrofitkotlinexampleapp.viewmodel.WikiViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity()
{
    @Inject lateinit var wikiMapper: WikiMapper

    @Inject lateinit var wikiViewModel: WikiViewModel

    private lateinit var textFormat: String

    private lateinit var inputtedString: String

    private val searchInfoObserver: Observer<SearchInfo> = Observer {
        text_results.text = CommonUtils.formatString(textFormat, it.totalhits.toString(), inputtedString)
    }

    private val onSearchClick = View.OnClickListener {
        inputtedString = edit_text.text.toString()
        wikiViewModel.getWikiData(wikiMapper.getWikiRequest(inputtedString))
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        DaggerAppComponent.create().inject(this)

        loadResources()

        setupUI()

        setupObservers()
    }

    private fun setupObservers()
    {
        wikiViewModel.getWikiResponse()?.observe(this, searchInfoObserver)
    }

    private fun loadResources()
    {
        textFormat = resources.getString(R.string.result_text)
    }

    private fun setupUI()
    {
        search_button.setOnClickListener(onSearchClick)
    }
}
