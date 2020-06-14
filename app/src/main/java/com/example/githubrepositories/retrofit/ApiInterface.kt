package com.example.githubrepositories.retrofit

import com.example.githubrepositories.model.RepoDetails
import com.example.githubrepositories.model.Repos
import com.example.githubrepositories.model.UserDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    companion object {
        private const val USER = "users?since=0"
    }

    @GET(USER)
    fun getUserDetails(): Call<ArrayList<UserDetails>>

    @GET("users/{login}/repos")
    fun getRepos(
        @Path("login") login: String
    ): Call<ArrayList<Repos>>

    @GET("repos/{login}/{name}")
    fun getRepoDetails(
        @Path("login") login: String,
        @Path("name") name: String
    ): Call<RepoDetails>

}