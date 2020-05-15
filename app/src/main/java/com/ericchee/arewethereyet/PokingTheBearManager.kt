package com.ericchee.arewethereyet

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

class PokingTheBearManager(private val context: Context) {

    private var workManager = WorkManager.getInstance(context)

    fun startAnnoyingTheHeckOuttaPerson() {
        if (isAWTYRunning()) {
            stopWork()
        }

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val workRequest = PeriodicWorkRequestBuilder<AskAQuestionWorker>(15, TimeUnit.MINUTES)
            .setInitialDelay(5000, TimeUnit.MILLISECONDS)
            .setConstraints(constraints)
            .addTag(AWTY_WORK_REQUEST_TAG)
            .build()


        workManager.enqueue(workRequest)

    }

    private fun isAWTYRunning(): Boolean {
        return when (workManager.getWorkInfosByTag(AWTY_WORK_REQUEST_TAG).get().firstOrNull()?.state) {
            WorkInfo.State.RUNNING,
            WorkInfo.State.ENQUEUED -> true
            else -> false
        }
    }

    fun stopWork() {
        workManager.cancelAllWorkByTag(AWTY_WORK_REQUEST_TAG)
    }


    companion object {
        const val AWTY_WORK_REQUEST_TAG = "AWTY_WORK_REQUEST_TAG"
    }

}