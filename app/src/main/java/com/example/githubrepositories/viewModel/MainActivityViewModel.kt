package com.example.githubrepositories.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.githubrepositories.dataSource.UserDataSouceFactory
import com.example.githubrepositories.dataSource.UserDataSource
import com.example.githubrepositories.model.UserDetails

class MainActivityViewModel() : ViewModel() {
    var userPagedList: LiveData<PagedList<UserDetails>>
    private var liveDataSource: LiveData<UserDataSource>

    init {
        val itemDataSourceFactory = UserDataSouceFactory()
        liveDataSource = itemDataSourceFactory.userLiveDataSource
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserDataSource.PAGE_SIZE)
            .build()
        userPagedList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()
    }
}