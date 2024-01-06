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
import com.garisea.views.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityUserDetailsBinding

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

                activityBinding.etUsername.error = "Field cannot be empty"
                activityBinding.etFirstName.error = "Field cannot be empty"
                activityBinding.etMiddleName.error = "Field cannot be empty"
                activityBinding.etLastName.error = "Field cannot be empty"
                activityBinding.etHomeCity.error = "Field cannot be empty"
                activityBinding.etHomeAddress.error = "Field cannot be empty"
                activityBinding.etMonthlyIncome.error = "Field cannot be empty"
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
            }


        }
    }
}