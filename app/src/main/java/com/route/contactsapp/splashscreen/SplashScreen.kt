package com.route.contactsapp.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.route.contactsapp.R
import com.route.contactsapp.contactscreen.ContactActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startContactActivity()
    }
    private fun startContactActivity(){
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this,ContactActivity::class.java))
            finish()
        },3000)
    }
}