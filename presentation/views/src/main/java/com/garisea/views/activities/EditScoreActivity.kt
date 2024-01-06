package com.garisea.views.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.garisea.datasets.MyPreferences
import com.garisea.views.R
import com.garisea.views.databinding.ActivityEditScoreBinding

class EditScoreActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityEditScoreBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityEditScoreBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = resources.getColor(R.color.greenPrimary)
        }


        val pref = MyPreferences(this)


        val topBarTile = findViewById<TextView>(R.id.topBarTile)
        topBarTile.text = getString(R.string.update_credit_score)

        val toolBarBackBtn = findViewById<ImageView>(R.id.toolBarBackBtn)
        toolBarBackBtn.setOnClickListener{
            finish()
        }

        activityBinding.submitBtn.setBackgroundColor(getColor(R.color.greenPrimary))
        activityBinding.submitBtn.setOnClickListener{

            if (TextUtils.isEmpty(activityBinding.etCreditScore.text.toString())
                || TextUtils.isEmpty(activityBinding.etAmount.text.toString())) {
                activityBinding.etCreditScore.error = "Field cannot be empty"
                activityBinding.etAmount.error = "Field cannot be empty"
            } else {
                val creditScore = activityBinding.etCreditScore.text.toString()
                val amount = activityBinding.etAmount.text.toString()


                pref.setCreditScore(creditScore)
                pref.setAmountToPutDown(amount)
            }


        }

    }
}