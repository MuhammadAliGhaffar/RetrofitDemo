package com.example.retrofitdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.data.models.User

class UsersAdapter(private val list: List<User>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    /**
     * onClickItem RelativeLayout
     */
    var onItemClick: ((User) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.users_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userModel = list[position]
        holder.imageView.setImageResource(userModel.getavatar_url())
        holder.username_textView.text = "Username :${userModel.getusername()}"
        holder.profile_url_textView.text = "Profile :${userModel.getprofile_url()}"
        holder.starred_url_textView.text = "Starred :${userModel.getstarred_url()}"
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.avatar_url)
        val username_textView: TextView = itemView.findViewById(R.id.username)
        val profile_url_textView: TextView = itemView.findViewById(R.id.profile_url)
        val starred_url_textView: TextView = itemView.findViewById(R.id.starred_url)
        val relativeLL: RelativeLayout = itemView.findViewById(R.id.relativeLL)

        /**
         * Item click implementation
         */
        init {
            relativeLL.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }
        }
    }
}