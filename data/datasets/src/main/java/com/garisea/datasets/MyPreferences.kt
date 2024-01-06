package com.garisea.datasets
import android.content.Context
import android.content.SharedPreferences


class MyPreferences(context: Context) {


    private var privateMode = 0

    // Shared Preferences
    private var pref: SharedPreferences? = null

    // Editor for Shared preferences
    private var editor: SharedPreferences.Editor? = null
    private val prefName = "garisea"

    // Context
    var context: Context? = context

    val str: String = "Hello Benjamin"

    private val creditScoreKey = "creditScore"

    private val amountPutDownKey = "amount"

    private val userNameKey = "username"
    private val firstNameKey = "firstname"
    private val middleNameKey = "middle_name"
    private val lastNameKey = "last_name"
    private val homeCityKey = "home_city"
    private val homeAddressKey = "home_address"
    private val monthlyIncomeKey = "monthly_income"


    //Constructor
    init {
        pref = this.context?.getSharedPreferences(prefName, privateMode)
        editor = pref?.edit()
    }


    //CREDIT SCORE
    fun setCreditScore(userName: String?) {
        editor!!.putString(creditScoreKey, userName)
        editor!!.commit()
    }

    fun getCreditScore(): String? {
        return if (pref!!.getString(creditScoreKey, null) != null) pref!!.getString(
            creditScoreKey,
            null
        ) else null
    }


    //AMOUNT WILLING TO PUT DOWN
    fun setAmountToPutDown(userName: String?) {
        editor!!.putString(amountPutDownKey, userName)
        editor!!.commit()
    }

    fun getAmountToPutDown(): String? {
        return if (pref!!.getString(amountPutDownKey, null) != null) pref!!.getString(
            amountPutDownKey,
            null
        ) else null
    }



    //USER DETAILS
    fun setUserName(userName: String?) {
        editor!!.putString(userNameKey, userName)
        editor!!.commit()
    }

    fun getUserName(): String? {
        return if (pref!!.getString(userNameKey, null) != null) pref!!.getString(
            userNameKey,
            null
        ) else null
    }

    fun setFirstName(firstName: String?) {
        editor!!.putString(firstNameKey, firstName)
        editor!!.commit()
    }

    fun getFirstName(): String? {
        return if (pref!!.getString(firstNameKey, null) != null) pref!!.getString(
            firstNameKey,
            null
        ) else null
    }

    fun setMiddleName(middleName: String?) {
        editor!!.putString(middleNameKey, middleName)
        editor!!.commit()
    }

    fun getMiddleName(): String? {
        return if (pref!!.getString(middleNameKey, null) != null) pref!!.getString(
            middleNameKey,
            null
        ) else null
    }

    fun setLastName(lastName: String?) {
        editor!!.putString(lastNameKey, lastName)
        editor!!.commit()
    }

    fun getLastName(): String? {
        return if (pref!!.getString(lastNameKey, null) != null) pref!!.getString(
            lastNameKey,
            null
        ) else null
    }

    fun setHomeCity(homeCity: String?) {
        editor!!.putString(homeCityKey, homeCity)
        editor!!.commit()
    }

    fun getHomeCity(): String? {
        return if (pref!!.getString(homeCityKey, null) != null) pref!!.getString(
            homeCityKey,
            null
        ) else null
    }

    fun setHomeAddress(homeAddress: String?) {
        editor!!.putString(homeAddressKey, homeAddress)
        editor!!.commit()
    }

    fun getHomeAddress(): String? {
        return if (pref!!.getString(homeAddressKey, null) != null) pref!!.getString(
            homeAddressKey,
            null
        ) else null
    }

    fun setMonthlyIncome(monthlyIncome: String?) {
        editor!!.putString(monthlyIncomeKey, monthlyIncome)
        editor!!.commit()
    }

    fun getMonthlyIncome(): String? {
        return if (pref!!.getString(monthlyIncomeKey, null) != null) pref!!.getString(
            monthlyIncomeKey,
            null
        ) else null
    }
}