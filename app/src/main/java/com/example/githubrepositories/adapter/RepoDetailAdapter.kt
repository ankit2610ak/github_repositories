package com.example.githubrepositories.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepositories.R
import com.example.githubrepositories.RepoActivity
import com.example.githubrepositories.model.Repos

class RepoDetailAdapter(
    private val repoArrayList: ArrayList<Repos>
    , private val context: Context

) : RecyclerView.Adapter<RepoDetailAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(

            LayoutInflater.from(context).inflate(R.layout.list_item_repo, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return repoArrayList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val userDetails = repoArrayList[position]
        holder.name.text = userDetails.full_name
        holder.watchers.text = userDetails.watchers.toString()

       /* holder.itemView.setOnClickListener {
            val intent = Intent(context, RepoActivity::class.java).apply {
//                putExtra("login",userDetails.login)
            }
            context.startActivity(intent)
*/
//        }
    }

    class CustomViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var name: TextView = itemLayoutView.findViewById(R.id.name)
        var watchers: TextView = itemLayoutView.findViewById(R.id.watchers)

    }

}

