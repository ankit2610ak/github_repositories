package com.example.githubrepositories.dataSource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.githubrepositories.model.UserDetails

class UserDataSouceFactory: DataSource.Factory<Int,UserDetails>() {
    val userLiveDataSource = MutableLiveData<UserDataSource>()

    override fun create(): DataSource<Int, UserDetails> {
        val userDataSource = UserDataSource()
        userLiveDataSource.postValue(userDataSource)
        return userDataSource
    }
}