package com.example.retrofitdemo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.repository.Repository
import com.example.retrofitdemo.repository.RetrofitService
import com.example.retrofitdemo.ui.adapter.UsersAdapter
import com.example.retrofitdemo.ui.viewModel.FactoryViewModel
import com.example.retrofitdemo.ui.viewModel.UserViewModel


class UserFragment : Fragment() {

    lateinit var userviewModel: UserViewModel
    private val retrofitService = RetrofitService.getInstance()
    private lateinit var recyclerView: RecyclerView
    private var usersAdapter = UsersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_user, container, false)
        userviewModel =
            ViewModelProvider(requireActivity(), FactoryViewModel(Repository(retrofitService))).get(
                UserViewModel::class.java
            )
        initView(view)
        return view
    }

    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = usersAdapter
        userviewModel.userList.observe(this.viewLifecycleOwner, Observer {
            Log.i("AliTag", "onCreate: $it")
            usersAdapter.setuserList(it)
        })
        userviewModel.errorMessage.observe(this.viewLifecycleOwner, Observer {
            Log.i("AliTag", "error: $it")
        })
        userviewModel.getAllUsers()

        usersAdapter.onItemClick = { user: User, i: Int ->
            Toast.makeText(context, user.toString(), Toast.LENGTH_SHORT).show()
        }

    }
}