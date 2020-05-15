package com.ericchee.arewethereyet

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class AskAQuestionWorker(private val context: Context, workParams: WorkerParameters): Worker(context , workParams) {


    override fun doWork(): Result {

        Log.i("echee", "Are we there yet!!!!?????!!!")

        return Result.success()
    }
}