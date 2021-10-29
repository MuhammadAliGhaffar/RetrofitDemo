package com.example.retrofitdemo.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.ui.adapter.UsersAdapter


class UserFragment : Fragment() {

    private lateinit var recyclerView:RecyclerView
    private lateinit var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view:View = inflater.inflate(R.layout.fragment_user, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val list = ArrayList<User>()
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))
        list.add(User("Muhammad Ali Ghaffar",R.drawable.ic_launcher_background,"ali.com","ghaffar.com"))

        usersAdapter = UsersAdapter(list)
        recyclerView.adapter = usersAdapter

        usersAdapter.onItemClick = {
            Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show()
        }

    }
}