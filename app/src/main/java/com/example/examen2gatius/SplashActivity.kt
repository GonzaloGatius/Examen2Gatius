package com.example.examen2gatius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {

    private lateinit var loadingSpinner: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loadingSpinner = findViewById(R.id.loadingSpinner)
        loadingSpinner.alpha = 1f

        Handler(Looper.getMainLooper()).postDelayed({
            loadingSpinner.animate().alpha(0f).setDuration(1800).withEndAction {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }, 3000)

    }
}
