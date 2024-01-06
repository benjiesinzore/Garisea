package com.garisea.application

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.garisea.datasets.MyPreferences
import com.garisea.views.activities.CreditScoredDataActivity
import com.garisea.views.activities.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 2_000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = resources.getColor(com.garisea.views.R.color.greenPrimary)
        }

        val gifResourceId = R.drawable.gif_drive
        val imageView = findViewById<ImageView>(R.id.loadGif)

        val username = MyPreferences(this).getUserName()

        // Using Glide to load and display the GIF
        Glide.with(this)
            .asGif()
            .load(gifResourceId)
            .into(imageView)

        Handler(Looper.getMainLooper()).postDelayed({
            // Start the main activity after the splash time out
            val creditScoreIntent = Intent(this, CreditScoredDataActivity::class.java)
            val mainActivityIntent = Intent(this, MainActivity::class.java)

            if(username == null){
                startActivity(creditScoreIntent)
                finish()
            } else {
                startActivity(mainActivityIntent)
                finish()
            }

        }, splashTimeOut)
    }
}



//#8438ff