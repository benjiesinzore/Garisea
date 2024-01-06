package com.garisea.datasets.local
import android.content.Context
import com.garisea.datasets.local.models.FinancingWrapper
import com.garisea.datasets.local.models.OffersWrapper
import com.garisea.datasets.local.models.TipsWrapper
import com.google.gson.Gson

class ParseJsonData(context: Context) {

    private val gson = Gson()

    //FINANCING
    private val financingJsonData = "financing".readJsonFile(context)
    val financingWrapper : FinancingWrapper = gson.fromJson(financingJsonData,
        FinancingWrapper::class.java)


    //TIPS
    private val tipsJsonData = "tips".readJsonFile(context)
    val tipsWrapper : TipsWrapper = gson.fromJson(tipsJsonData,
        TipsWrapper::class.java)


    //OFFERS
    private val offersJsonData = "offers".readJsonFile(context)
    val offersWrapper : OffersWrapper = gson.fromJson(offersJsonData,
        OffersWrapper::class.java)


    private fun String.readJsonFile(context: Context): String {
        return context.resources.openRawResource(context.resources.getIdentifier(this,
            "raw", context.packageName)).bufferedReader().use { it.readText() }
    }


}