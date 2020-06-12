package com.example.githubrepositories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepositories.adapter.UserDetailAdapter
import com.example.githubrepositories.model.UserDetails
import com.example.githubrepositories.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UserDetailAdapter
    var usersList: ArrayList<UserDetails> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.user_list_recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val model: MainActivityViewModel =
            ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        model._livedata.observe(this, Observer {
            usersList.clear()
            usersList.addAll(it)
            adapter.notifyDataSetChanged()
        })
        adapter = UserDetailAdapter(usersList, this)

        model.getUserDetails()
        recyclerView.adapter = adapter


    }
}