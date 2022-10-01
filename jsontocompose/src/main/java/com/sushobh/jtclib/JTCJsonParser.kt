package com.sushobh.jtclib

import android.util.Log
import com.sushobh.jtclib.dataparsers.*
import com.sushobh.jtclib.viewdata.JTCViewData
import com.sushobh.jtclib.viewtypes.JTC_VIEW_DATA
import com.sushobh.jtclib.viewtypes.JTC_VIEW_TYPE
import org.json.JSONObject

class JTCJsonParser(val data : JSONObject,val customDataHandler: JTCCustomDataHandler? = null) {


    private val viewDataParsers : ArrayList<JTCViewDataParser> = arrayListOf()

    init {
        viewDataParsers.add(JTCColumParser)
        viewDataParsers.add(JTCLHorzSliderParser)
        viewDataParsers.add(JTCListParser)
        viewDataParsers.add(JTCUrlImageParser)
        viewDataParsers.add(JTCTextParser)
        viewDataParsers.add(JTCButtonParser)
    }


    open fun getViewDataParser(key : String) : JTCViewDataParser? {
        Log.i("Eventy","Handling key ${key}")
        customDataHandler?.let {
            val handler = it.handle(key)
            handler?.let {
                return handler
            }
        }
        return viewDataParsers.find {
            it.canParse(key)
        }
    }

    fun parse() : JTCViewData?{
        val rootViewType = data.get(JTC_VIEW_TYPE) as String
        return getViewDataParser(rootViewType)?.parse(data.get(JTC_VIEW_DATA) as JSONObject,customDataHandler)
    }

}