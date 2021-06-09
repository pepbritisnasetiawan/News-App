package com.dicoding.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val ivSplash: ImageView = findViewById(R.id.iv_splash)
        ivSplash.alpha = 0f
        ivSplash.animate().setDuration(1000).alpha(1f).withEndAction {
            val i = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }
}