package com.garisea.views.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.garisea.datasets.MyPreferences
import com.garisea.views.HandleCustomDialog
import com.garisea.views.R
import com.garisea.views.databinding.ActivityCreditScoredDataBinding

class CreditScoredDataActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityCreditScoredDataBinding

    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityCreditScoredDataBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = resources.getColor(R.color.greenPrimary)
        }

        val pref = MyPreferences(this)


        activityBinding.submitBtn.setBackgroundColor(getColor(R.color.greenPrimary))
        activityBinding.submitBtn.setOnClickListener{

            if (TextUtils.isEmpty(activityBinding.etUsername.text.toString()) || TextUtils.isEmpty(activityBinding.etCreditScore.text.toString())
                || TextUtils.isEmpty(activityBinding.etAmount.text.toString())) {
                activityBinding.etUsername.error = getString(R.string.field_cannot_be_empty)
                activityBinding.etCreditScore.error = getString(R.string.field_cannot_be_empty)
                activityBinding.etAmount.error = getString(R.string.field_cannot_be_empty)
            } else {
                val username = activityBinding.etUsername.text.toString()
                val creditScore = activityBinding.etCreditScore.text.toString().toInt()
                val amount = activityBinding.etAmount.text.toString()

                pref.setUserName(username)
                pref.setCreditScore(creditScore)
                pref.setAmountToPutDown(amount)

                val handleCustomDialog = HandleCustomDialog(this)
                handleCustomDialog.showLoadingDialog()

                Handler(Looper.getMainLooper()).postDelayed({
                    handleCustomDialog.hideLoadingDialog()

                    Toast.makeText(this,
                        getString(R.string.data_was_updated_successfully), Toast.LENGTH_SHORT).show()

                    val mainActivityIntent = Intent(this, MainActivity::class.java)
                    startActivity(mainActivityIntent)
                    finish()

                }, 5000)
            }


        }
    }




}