package com.example.retrofitdemo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.ui.adapter.UsersAdapter
import com.example.retrofitdemo.ui.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var usersAdapter: UsersAdapter
    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_user, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = usersAdapter

        viewModel.userList.observe(
            this.viewLifecycleOwner,
            Observer {
                usersAdapter.setuserList(it)
            }
        )
        viewModel.errorMessage.observe(
            this.viewLifecycleOwner,
            Observer {
                Log.d("_debug", "error: $it")
            }
        )
        usersAdapter.onItemClick = { user: User ->
            Toast.makeText(context, "ID :${user.id}\nUsername :${user.username}", Toast.LENGTH_SHORT).show()
        }

        viewModel.getAllUsers()
    }
}
