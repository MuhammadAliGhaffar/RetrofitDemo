package com.example.retrofitdemo.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.retrofitdemo.repository.CoreRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class UserWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val coreRepository: CoreRepository
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        withContext(Dispatchers.IO) {
            coreRepository.getUser().collect {
                it.data?.let { it ->
                    coreRepository.allDatabaseUsers().userDao().insertUser(it)
                    Log.d("_debug", "Worker Called - Updated list added in Database $it")
                }
            }
        }
        return Result.failure()
    }
}
