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
    var onItemClick: ((User, pos: Int) -> Unit)? = null

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

        //holder.imageView.setImageResource(userModel.getavatar_url())
        Glide.with(holder.imageView.context).load(userModel.avatar_url).into(holder.imageView)
        holder.txtUsername.text = "Username :${userModel.username}"
        holder.profile_url_textView.text = "Profile :${userModel.profile_url}"
        holder.starred_url_textView.text = "Starred :${userModel.starred_url}"
        /**
         * Item click implementation
         */
        holder.relativeLL.setOnClickListener {
            onItemClick?.invoke(list[position], position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.avatar_url)
        val txtUsername: TextView = itemView.findViewById(R.id.username)
        val profile_url_textView: TextView = itemView.findViewById(R.id.profile_url)
        val starred_url_textView: TextView = itemView.findViewById(R.id.starred_url)
        val relativeLL: RelativeLayout = itemView.findViewById(R.id.relativeLL)
    }
}