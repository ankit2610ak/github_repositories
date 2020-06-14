package com.example.githubrepositories.viewModel

import ApiClient
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepositories.model.RepoDetails
import retrofit2.Call
import retrofit2.Response

class RepoDetailsActivityViewModel : ViewModel() {
    private var liveData: MutableLiveData<RepoDetails> = MutableLiveData()
    val _livedata: LiveData<RepoDetails>
        get() = liveData

    fun getRepoDetails(login: String, name: String) {
        val call: Call<RepoDetails> = ApiClient.getClient.getRepoDetails(login, name)
        call.enqueue(object : retrofit2.Callback<RepoDetails> {
            override fun onFailure(call: Call<RepoDetails>, t: Throwable) {
                Log.d("RepoActivityViewModel", t.message.toString())
            }

            override fun onResponse(
                call: Call<RepoDetails>,
                response: Response<RepoDetails>
            ) {
                val repoList = response.body()
                liveData.postValue(repoList)
            }

        })
    }

}
