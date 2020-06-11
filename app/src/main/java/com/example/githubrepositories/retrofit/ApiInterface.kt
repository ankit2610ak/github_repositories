package com.example.githubrepositories.retrofit

import com.example.githubrepositories.model.UserDetails
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    companion object {
        private const val USER = "users?since=0"
    }

    @GET(USER)
    fun getUserDetails(): Call<UserDetails>

}