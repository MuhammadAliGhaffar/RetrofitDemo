package com.example.retrofitdemo.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.retrofitdemo.repository.Repository
import com.example.retrofitdemo.repository.RetrofitService
import com.example.retrofitdemo.room.UserDAO
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class UserWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val userDAO: UserDAO,
    private val retrofitService: RetrofitService
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        withContext(Dispatchers.IO) {
            val response = retrofitService.getAllUsers()
            if (response.isSuccessful) {
                response.body()?.let {
                    userDAO.insertUser(it)
                    Log.d("_debug", "Worker Called - Updated list added in Database $it")
                }

            }
        }

        return Result.failure()
    }
}
