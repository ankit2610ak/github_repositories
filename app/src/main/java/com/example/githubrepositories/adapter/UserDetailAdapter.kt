package com.example.githubrepositories.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrepositories.R
import com.example.githubrepositories.RepoActivity
import com.example.githubrepositories.model.UserDetails

class UserDetailAdapter :
    PagedListAdapter<UserDetails, UserDetailAdapter.CustomViewHolder>(USER_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(

            LayoutInflater.from(parent.context).inflate(R.layout.list_item_users, parent, false)
        )

    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(it) }

    }

    class CustomViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var userPhoto: ImageView = itemLayoutView.findViewById(R.id.userPhoto)
        var login: TextView = itemLayoutView.findViewById(R.id.login)
        var type: TextView = itemLayoutView.findViewById(R.id.type)

        fun bind(user: UserDetails) {
            login.text = user.login
            type.text = user.type
            Glide.with(userPhoto.context)
                .load(user.avatar_url)
                .into(userPhoto)
            itemView.setOnClickListener {
                val intent = Intent(it.context, RepoActivity::class.java).apply {
                    putExtra("login", user.login)
                }
                it.context.startActivity(intent)

            }
        }

    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<UserDetails>() {
            override fun areItemsTheSame(oldItem: UserDetails, newItem: UserDetails): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UserDetails, newItem: UserDetails): Boolean =
                newItem == oldItem
        }
    }

}
