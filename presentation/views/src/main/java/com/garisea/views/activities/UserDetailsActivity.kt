package com.garisea.views.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.garisea.datasets.MyPreferences
import com.garisea.views.HandleCustomDialog
import com.garisea.views.R
import com.garisea.views.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityUserDetailsBinding

    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = resources.getColor(R.color.greenPrimary)
        }

        val pref = MyPreferences(this)


        val topBarTile = findViewById<TextView>(R.id.topBarTile)
        topBarTile.text = getString(R.string.update_user_info)

        val toolBarBackBtn = findViewById<ImageView>(R.id.toolBarBackBtn)
        toolBarBackBtn.setOnClickListener{
            finish()
        }

        activityBinding.submitBtn.setBackgroundColor(getColor(R.color.greenPrimary))
        activityBinding.submitBtn.setOnClickListener{

            if (TextUtils.isEmpty(activityBinding.etUsername.text.toString()) || TextUtils.isEmpty(activityBinding.etFirstName.text.toString())
                || TextUtils.isEmpty(activityBinding.etLastName.text.toString()) || TextUtils.isEmpty(activityBinding.etMiddleName.text.toString())
                || TextUtils.isEmpty(activityBinding.etHomeCity.text.toString()) || TextUtils.isEmpty(activityBinding.etHomeAddress.text.toString())
                || TextUtils.isEmpty(activityBinding.etMonthlyIncome.text.toString())) {

                activityBinding.etUsername.error = getString(R.string.field_cannot_be_empty)
                activityBinding.etFirstName.error = getString(R.string.field_cannot_be_empty)
                activityBinding.etMiddleName.error = getString(R.string.field_cannot_be_empty)
                activityBinding.etLastName.error = getString(R.string.field_cannot_be_empty)
                activityBinding.etHomeCity.error = getString(R.string.field_cannot_be_empty)
                activityBinding.etHomeAddress.error = getString(R.string.field_cannot_be_empty)
                activityBinding.etMonthlyIncome.error = getString(R.string.field_cannot_be_empty)
            } else {
                val username = activityBinding.etUsername.text.toString()
                val firstName = activityBinding.etFirstName.text.toString()
                val middleName = activityBinding.etMiddleName.text.toString()
                val lastName = activityBinding.etLastName.text.toString()
                val homeCity = activityBinding.etHomeCity.text.toString()
                val homeAddress = activityBinding.etHomeAddress.text.toString()
                val monthlyIncome = activityBinding.etMonthlyIncome.text.toString()

                pref.setUserName(username)
                pref.setFirstName(firstName)
                pref.setMiddleName(middleName)
                pref.setLastName(lastName)
                pref.setHomeCity(homeCity)
                pref.setHomeAddress(homeAddress)
                pref.setMonthlyIncome(monthlyIncome)


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