package com.example.githubrepositories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepositories.adapter.ReposAdapter
import com.example.githubrepositories.model.Repos
import com.example.githubrepositories.viewModel.RepoActivityViewModel

class RepoActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ReposAdapter
    var repoList: ArrayList<Repos> = ArrayList()
    lateinit var login: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)
        login = intent.getStringExtra("login")
        recyclerView = findViewById(R.id.repo_list_recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val model: RepoActivityViewModel =
            ViewModelProviders.of(this).get(RepoActivityViewModel::class.java)

        model._livedata.observe(this, Observer {
            repoList.clear()
            repoList.addAll(it)
            adapter.notifyDataSetChanged()
        })
        adapter = ReposAdapter(repoList, this)

        model.getRepoDetails(login)
        recyclerView.adapter = adapter


    }
}