package com.team7.tikkle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.team7.tikkle.login.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val userAccessToken = GlobalApplication.prefs.getString("userAccessToken", "")

        // Splash Handler
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            if (userAccessToken == "") {
                Intent(this, MainActivity::class.java).apply {
                    startActivity(this)
                    overridePendingTransition(0, 0);
                    finish()
                }
            } else {
                Intent(this, HomeActivity::class.java).apply {
                    startActivity(this)
                    overridePendingTransition(0, 0);
                    finish()
                }
            }
        }, 2000)
    }
}
