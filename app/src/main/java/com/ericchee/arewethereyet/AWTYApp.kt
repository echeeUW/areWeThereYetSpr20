package com.ericchee.arewethereyet

import android.app.Application

class AWTYApp: Application() {

    lateinit var pokingTheBearManager: PokingTheBearManager
        private set

    lateinit var awtyNotificationManager: AWTYNotificationManager
        private set

    override fun onCreate() {
        super.onCreate()

        pokingTheBearManager = PokingTheBearManager(this)
        awtyNotificationManager = AWTYNotificationManager(this)

    }
}