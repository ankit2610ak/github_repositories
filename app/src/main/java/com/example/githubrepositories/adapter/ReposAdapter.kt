package com.example.githubrepositories.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrepositories.R
import com.example.githubrepositories.RepoDetailsActivity
import com.example.githubrepositories.model.Repos

class ReposAdapter(
    private val repoArrayList: ArrayList<Repos>
    , private val context: Context

) : RecyclerView.Adapter<ReposAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(

            LayoutInflater.from(context).inflate(R.layout.list_item_repo, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return repoArrayList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val userDetails = repoArrayList[position]
        holder.name.text = "Name: " +userDetails.full_name
        holder.watchers.text = userDetails.watchers.toString()
        holder.branch.text = userDetails.default_branch
        Glide.with(context).load(userDetails.owner.avatar_url).into(holder.pic)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, RepoDetailsActivity::class.java).apply {
                putExtra("name", userDetails.name)
                putExtra("login", userDetails.owner.login)
            }
            context.startActivity(intent)

        }
    }

    class CustomViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var name: TextView = itemLayoutView.findViewById(R.id.name)
        var watchers: TextView = itemLayoutView.findViewById(R.id.watchers)
        var branch : TextView = itemLayoutView.findViewById(R.id.branch)
        var pic: ImageView = itemLayoutView.findViewById(R.id.pic)

    }

}

