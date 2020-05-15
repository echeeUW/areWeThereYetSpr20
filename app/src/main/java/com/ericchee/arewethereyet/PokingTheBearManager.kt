package com.ericchee.arewethereyet

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

class PokingTheBearManager(private val context: Context) {

    private var workManager = WorkManager.getInstance(context)

    fun startAnnoyingTheHeckOuttaPerson() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val workRequest = PeriodicWorkRequestBuilder<AskAQuestionWorker>(15, TimeUnit.MINUTES)
            .setInitialDelay(5000, TimeUnit.MILLISECONDS)
            .setConstraints(constraints)
            .build()
        
        workManager.enqueue(workRequest)
    }




}