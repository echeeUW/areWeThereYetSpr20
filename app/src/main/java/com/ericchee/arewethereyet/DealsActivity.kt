package com.ericchee.arewethereyet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_deals.*

class DealsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deals)

        val someDataFromNotification = intent.getStringExtra("hello")

        tvInfo.text = someDataFromNotification
    }
}
