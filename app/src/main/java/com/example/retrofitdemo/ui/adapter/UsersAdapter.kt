package com.example.retrofitdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitdemo.R
import com.example.retrofitdemo.data.models.User
import javax.inject.Inject

class UsersAdapter @Inject constructor() : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    var list = mutableListOf<User>()

    /**
     * onClickItem RelativeLayout
     */
    var onItemClick: ((User) -> Unit)? = null

    fun setuserList(list: List<User>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userModel = list[position]

        // holder.imageView.setImageResource(userModel.getavatar_url())
        Glide.with(holder.avatarImageView.context).load(userModel.avatarUrl).into(holder.avatarImageView)
        holder.usernameTextView.text = "Username :${userModel.username}"
        holder.profileTextView.text = "Profile :${userModel.profileUrl}"
        holder.starredTextView.text = "Starred :${userModel.starredUrl}"
        /**
         * Item click implementation
         */
        holder.relativeLL.setOnClickListener {
            onItemClick?.invoke(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
        val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
        val profileTextView: TextView = itemView.findViewById(R.id.profileTextView)
        val starredTextView: TextView = itemView.findViewById(R.id.starredTextView)
        val relativeLL: RelativeLayout = itemView.findViewById(R.id.relativeLL)
    }
}
