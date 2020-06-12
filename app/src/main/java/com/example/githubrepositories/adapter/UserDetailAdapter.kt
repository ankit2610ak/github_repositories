package com.example.githubrepositories.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrepositories.R
import com.example.githubrepositories.model.UserDetails

class UserDetailAdapter(
    private val usersArrayList: ArrayList<UserDetails>
    , private val context: Context
) : RecyclerView.Adapter<UserDetailAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(

            LayoutInflater.from(context).inflate(R.layout.list_item_users, parent, false)
        )

    }

    override fun getItemCount(): Int {
      return  usersArrayList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val userDetails = usersArrayList[position]
        Glide.with(context).load(userDetails.avatar_url).into(holder.userPhoto)

    }

    class CustomViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var userPhoto: ImageView = itemLayoutView.findViewById(R.id.userPhoto)

    }

}
