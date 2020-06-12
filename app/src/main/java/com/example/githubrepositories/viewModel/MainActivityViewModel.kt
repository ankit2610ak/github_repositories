package com.example.githubrepositories.viewModel

import ApiClient
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepositories.model.UserDetails
import retrofit2.Call
import retrofit2.Response

class MainActivityViewModel() : ViewModel() {
    private var liveData:MutableLiveData<ArrayList<UserDetails>> = MutableLiveData()
    val _livedata : LiveData<ArrayList<UserDetails>>
        get() = liveData

    fun getUserDetails() {
        val call: Call<ArrayList<UserDetails>> = ApiClient.getClient.getUserDetails()
        call.enqueue(object : retrofit2.Callback<ArrayList<UserDetails>> {
            override fun onFailure(call: Call<ArrayList<UserDetails>>, t: Throwable) {
                Log.d("MainActivityViewModel", t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<UserDetails>>,
                response: Response<ArrayList<UserDetails>>
            ) {
                val userList = response.body()
                liveData.postValue(userList)
              }

        })
    }

}