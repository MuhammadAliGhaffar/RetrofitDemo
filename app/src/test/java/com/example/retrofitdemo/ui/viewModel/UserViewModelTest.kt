package com.example.retrofitdemo.ui.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.retrofitdemo.data.models.User
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class UserViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    lateinit var userList: MutableLiveData<List<User>>
    private lateinit var errorMessage: MutableLiveData<String>
    private lateinit var list: List<User?>

    /**
     * - Check whether my user list is null or not
     * - Check if my list is null error message produce error message
     * - Check Connection if mobile in connected to network or Wifi return else false
     */

    @Test
    fun `Check whether my list is null or not`() {
        list = ArrayList<User>()
        assertEquals(true, list.isEmpty())
    }

    @Test
    fun `Check if my list is null error message produce error message`() {
        errorMessage = MutableLiveData()
        list = ArrayList<User>()
        errorMessage.value = if (list.isEmpty()) "List is Empty" else "List have some Data"
        assertEquals("List is Empty", errorMessage.value)
    }

    @Test
    fun `Check if my list is not null message produce have some data message`() {
        errorMessage = MutableLiveData()
        list = ArrayList<User>()
        list = listOf(User(1, "Ali", "Ali", "Ali", "Ali"))
        errorMessage.value = if (list.isEmpty()) "List is Empty" else "List have some Data"
        assertEquals("List have some Data", errorMessage.value)
    }
}
