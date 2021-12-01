package com.example.retrofitdemo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.retrofitdemo.R
import com.example.retrofitdemo.Utils
import com.example.retrofitdemo.data.models.User
import com.example.retrofitdemo.ui.adapter.UsersAdapter
import com.example.retrofitdemo.ui.viewModel.ItemViewModel
import com.example.retrofitdemo.ui.viewModel.UserViewModel
import com.example.retrofitdemo.worker.UserWorker
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class UserFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fL: FrameLayout

    @Inject
    lateinit var usersAdapter: UsersAdapter
    private val viewModel: UserViewModel by viewModels()
    private val itemViewModel: ItemViewModel by activityViewModels()

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
        fL = view.findViewById(R.id.fL)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = usersAdapter

        viewModel.checkConnection.value = Utils.isOnline(requireContext())
        if (viewModel.checkConnection.value == true) {
            Snackbar.make(fL, "Online - Showing Items from API", Snackbar.LENGTH_LONG).show()
        } else {
            Snackbar.make(fL, "Offline - Showing Items from Database", Snackbar.LENGTH_LONG).show()
        }

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
            itemViewModel.user.postValue(user)
            findNavController().navigate(R.id.action_userFragment_to_itemFragment)
        }

        viewModel.getAllUsers()

        setupWork()
    }

    private fun setupWork() {
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workRequest = PeriodicWorkRequest.Builder(UserWorker::class.java, 6, TimeUnit.HOURS)
            .setConstraints(constraint).build()
        WorkManager.getInstance(requireContext()).enqueue(workRequest)
    }
}
