package com.garisea.views.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.garisea.views.R


class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null

    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = resources.getColor(R.color.greenPrimary)
        }


        val topBarTile = findViewById<TextView>(R.id.topBarTile)
        topBarTile.text = getString(R.string.garisea)

        val toolBarBackBtn = findViewById<ImageView>(R.id.toolBarBackBtn)
        toolBarBackBtn.setOnClickListener{
            finish()
        }

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)

        val rlDashboardBtnActBg = findViewById<RelativeLayout>(R.id.rlDashboardBtnActBg)
        rlDashboardBtnActBg.setOnClickListener { handleBottomAndTopBarStyling(getString(R.string.home)) }

        val rlTipsBtnActBg = findViewById<RelativeLayout>(R.id.rlCatalogBtn)
        rlTipsBtnActBg.setOnClickListener { handleBottomAndTopBarStyling(getString(R.string.tips)) }

        val rlOfferBtnActBg = findViewById<RelativeLayout>(R.id.rlAddBtn)
        rlOfferBtnActBg.setOnClickListener { handleBottomAndTopBarStyling(getString(R.string.offer)) }

        val rlProfileBtnActBg = findViewById<RelativeLayout>(R.id.rlTransactionBtn)
        rlProfileBtnActBg.setOnClickListener { handleBottomAndTopBarStyling(getString(R.string.profile)) }

        val rlProfileBtn = findViewById<RelativeLayout>(R.id.rlProfileBtn)
        rlProfileBtn.setOnClickListener{
            startActivity(Intent(this, UserDetailsActivity::class.java))
        }

        val rlSettingsBtn = findViewById<RelativeLayout>(R.id.rlSettingsBtn)
        rlSettingsBtn.setOnClickListener{
            startActivity(Intent(this, EditScoreActivity::class.java))
        }

        val rlHelpBtn = findViewById<RelativeLayout>(R.id.rlHelpBtn)
        rlHelpBtn.setOnClickListener{
            startActivity(Intent(this, HelpActivity::class.java))
        }


    }

    private fun handleBottomAndTopBarStyling(str: String){

        //Bottom Icon Background
        val rlDashboardBtnActBg = findViewById<RelativeLayout>(R.id.rlDashboardBtnActBg)
        val rlTipsBtnActBg = findViewById<RelativeLayout>(R.id.rlTipsBtnActBg)
        val rlOffersBtnActBg = findViewById<RelativeLayout>(R.id.rlOffersBtnActBg)
        val rlProfileBtnActBg = findViewById<RelativeLayout>(R.id.rlProfileBtnActBg)

        //Bottom-Bar Text
        val txDashboard = findViewById<TextView>(R.id.txDashboard)
        val txTips = findViewById<TextView>(R.id.txTips)
        val txOffers = findViewById<TextView>(R.id.txOffers)
        val txProfile = findViewById<TextView>(R.id.txProfile)



        when (str) {
            getString(R.string.home) -> {

                rlDashboardBtnActBg.setBackgroundResource(R.drawable.background_icon_active)
                rlTipsBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)
                rlOffersBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)
                rlProfileBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)


                txDashboard.visibility = View.VISIBLE
                txTips.visibility = View.INVISIBLE
                txOffers.visibility = View.INVISIBLE
                txProfile.visibility = View.INVISIBLE


                //HANDLE NAVIGATION
                navController?.navigateUp()
                navController?.navigate(R.id.action_DashboardFragment)
            }

            getString(R.string.tips) -> {

                rlDashboardBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)
                rlTipsBtnActBg.setBackgroundResource(R.drawable.background_icon_active)
                rlOffersBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)
                rlProfileBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)


                txDashboard.visibility = View.INVISIBLE
                txTips.visibility = View.VISIBLE
                txOffers.visibility = View.INVISIBLE
                txProfile.visibility = View.INVISIBLE

                //HANDLE NAVIGATION
                navController?.navigateUp()
                navController?.navigate(R.id.action_TipsFragment)
            }

            getString(R.string.offer) -> {

                rlDashboardBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)
                rlTipsBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)
                rlOffersBtnActBg.setBackgroundResource(R.drawable.background_icon_active)
                rlProfileBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)

                txDashboard.visibility = View.INVISIBLE
                txTips.visibility = View.INVISIBLE
                txOffers.visibility = View.VISIBLE
                txProfile.visibility = View.INVISIBLE


                //HANDLE NAVIGATION
                navController?.navigateUp()
                navController?.navigate(R.id.action_OfferFragment)
            }

            else -> {

                rlDashboardBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)
                rlTipsBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)
                rlOffersBtnActBg.setBackgroundResource(R.drawable.background_icon_inactive)
                rlProfileBtnActBg.setBackgroundResource(R.drawable.background_icon_active)

                txDashboard.visibility = View.INVISIBLE
                txTips.visibility = View.INVISIBLE
                txOffers.visibility = View.INVISIBLE
                txProfile.visibility = View.VISIBLE

                //HANDLE NAVIGATION
                navController?.navigateUp()
                navController?.navigate(R.id.action_ProfileFragment)
            }
        }



    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}