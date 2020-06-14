package com.example.githubrepositories

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.githubrepositories.viewModel.RepoDetailsActivityViewModel

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class RepoDetailsActivity : AppCompatActivity() {

    lateinit var login: String
    lateinit var name: String
    var description: TextView? = null
    var loginTextView: TextView? = null
    var forks: TextView? = null
    var watchers: TextView? = null
    var openIssues: TextView? = null
    var language: TextView? = null
    var photo: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_details)
        login = intent.getStringExtra("login")
        name = intent.getStringExtra("name")
        description = findViewById(R.id.description)
        loginTextView = findViewById(R.id.login_repo)
        forks = findViewById(R.id.forks)
        watchers = findViewById(R.id.watchers)
        openIssues = findViewById(R.id.open_issues)
        language = findViewById(R.id.language)
        photo = findViewById(R.id.photo)

        val model: RepoDetailsActivityViewModel =
            ViewModelProviders.of(this).get(RepoDetailsActivityViewModel::class.java)
        model._livedata.observe(this, Observer {
            description?.text = it.description
            loginTextView?.text = login
            forks?.text = it.forks.toString()
            watchers?.text = it.watchers.toString()
            openIssues?.text = it.open_issues.toString()
            language?.text = it.language
            Glide.with(this).load(it.owner.avatar_url).into(photo!!)
        })
        model.getRepoDetails(login, name)


    }
}