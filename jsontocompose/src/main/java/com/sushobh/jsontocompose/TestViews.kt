@file:OptIn(ExperimentalPagerApi::class)

package com.sushobh.jsontocompose

import android.content.Context
import android.content.res.AssetManager
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.sushobh.jsontocompose.viewdata.JTCUrlImageData
import com.sushobh.jsontocompose.viewtypes.JTCUrlImage
import org.json.JSONObject


@Composable
fun TestView(context : Context) {
      val data = JTCJsonParser(
          loadJsonObject("test3.json",context)).parse()
      val drawer = data?.let { ViewDrawer(it) }
      data?.let { drawer?.draw() }
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
