package com.example.retrofitdemo.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.retrofitdemo.data.models.User
import org.junit.Assert.*
import org.junit.Test

class ItemViewModelTest {
    @Test
    fun `user should not null when it get assigned value`() {
        var user: MutableLiveData<User>? = MutableLiveData<User>()
        assertNotNull(user)
    }

    @Test
    fun `username should not null after login`() {
        val user: User? = User(0, "null", "", "", "")
        assertNotNull(user?.username!!)
    }
}
