package com.example.retrofitdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.retrofitdemo.R
import com.example.retrofitdemo.ui.viewModel.ItemViewModel

class ItemFragment : Fragment() {

    private lateinit var backButton: ImageView
    private lateinit var userIDTextView: TextView
    private lateinit var usernameTextView: TextView
    private lateinit var avatarImageView: ImageView
    private val viewModel: ItemViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.item_fragment, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        backButton = view.findViewById(R.id.backButton)
        userIDTextView = view.findViewById(R.id.userIDTextView)
        avatarImageView = view.findViewById(R.id.avatarImageView)
        usernameTextView = view.findViewById(R.id.usernameTextView)

        userIDTextView.text = "User ID :${viewModel.user.value?.id}"
        usernameTextView.text = "Name :${viewModel.user.value?.username}"
        Glide.with(avatarImageView).load(viewModel.user.value?.avatarUrl).into(avatarImageView)

        backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
