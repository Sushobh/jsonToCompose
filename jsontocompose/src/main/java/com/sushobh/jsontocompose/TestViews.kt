@file:OptIn(ExperimentalPagerApi::class)

package com.sushobh.jsontocompose

import android.content.Context
import android.content.res.AssetManager
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import org.json.JSONObject


/**
 * 1) Create Data Type.
 * 2) Create View Type.
 * 3) Add JTC_VIEW variable strin
 * 3) Register ViewType
 * 4) Create Data Parser.
 * 5) Register Parser.
 */

@Composable
fun TestView(context : Context) {

     val full = loadJsonObject("example_full.json",context)
     val offerSlider = loadJsonObject("example_offer_slider.json",context)
     val kycPrompt = loadJsonObject("example_kyc_prompt.json",context)
     val productCategories = loadJsonObject("example_product_categories.json",context)
     val recentlyViewed = loadJsonObject("example_recent_views.json",context)
     addToColum(full,offerSlider)
     addToColum(full,productCategories)
     addToColum(full,kycPrompt)
     addToColum(full,recentlyViewed)
     val data = JTCJsonParser(
          full).parse()
      val drawer = data?.let { ViewDrawer(it) }
      data?.let { drawer?.draw() }
}

fun addToColum(full : JSONObject ,newItem: JSONObject){
    full.getJSONObject("JTC_VIEW_DATA").getJSONArray("JTC_LIST_DATA").put(newItem)
}

fun loadJsonObject(fileName: String,context: Context) : JSONObject {
    val jsonDataString = context.assets.readAssetsFile(fileName)
    return JSONObject(jsonDataString)
}

fun AssetManager.readAssetsFile(fileName : String): String {
    val stream = open(fileName)
    val string = stream.bufferedReader().readText()
    stream.close()
    return string
}
