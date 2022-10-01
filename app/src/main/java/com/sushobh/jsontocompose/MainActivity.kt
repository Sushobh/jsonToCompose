package com.sushobh.jsontocompose

import android.content.Context
import android.content.res.AssetManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.sushobh.jsontocompose.customjtc.JTCUpdateKyc
import com.sushobh.jsontocompose.customjtc.JTCUpdateKycData
import com.sushobh.jsontocompose.customjtc.JTCUpdateKycParser
import com.sushobh.jsontocompose.customjtc.JTC_UPDATE_KYC
import com.sushobh.jsontocompose.ui.theme.JsonToComposeTheme
import com.sushobh.jsontocompose.viewdata.JTCViewData
import com.sushobh.jsontocompose.viewtypes.JTCViewType
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Create custom data parser
        val customDataHandler = object : JTCCustomDataHandler {
            override fun handle(key: String): JTCViewDataParser? {
                return when(key){
                    JTC_UPDATE_KYC ->  JTCUpdateKycParser
                    else -> { null }
                }
            }
        }

        //Parse data from json first
        val jtcDataParser = JTCJsonParser(loadJsonObject("example_full.json",this),customDataHandler)

        val data = jtcDataParser.parse()

        //Initialize ViewDrawer based on data
        var jtcView : JTCJsonToCompose? = null

        //Create custom view handler, this handler can be null if no custom views are needed.
        val customViewHandler = object : JTCCustomViewDataHandler {
            override fun handle(viewData: JTCViewData): JTCViewType<*>? {
                return  when(viewData) {

                    //Update kyc is a custom view, so we handle it
                    is JTCUpdateKycData -> JTCUpdateKyc(viewData)
                    else -> {
                        null
                    }
                }
            }
        }

        //Initialize view
        data?.let {
            jtcView =  JTCJsonToCompose(data, customViewHandler)
        }

        setContent {
            JsonToComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                       Column{
                           //Draw view
                           jtcView?.draw()
                       }
                }
            }
        }
    }
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


