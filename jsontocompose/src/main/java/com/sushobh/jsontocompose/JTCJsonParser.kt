package com.sushobh.jsontocompose

import com.sushobh.jsontocompose.dataparsers.JTCColumParser
import com.sushobh.jsontocompose.dataparsers.JTCLHorzSliderParser
import com.sushobh.jsontocompose.dataparsers.JTCListParser
import com.sushobh.jsontocompose.dataparsers.JTCUrlImageParser
import com.sushobh.jsontocompose.viewdata.JTCViewData
import com.sushobh.jsontocompose.viewtypes.JTCHorizontalSlider
import com.sushobh.jsontocompose.viewtypes.JTC_VIEW_DATA
import com.sushobh.jsontocompose.viewtypes.JTC_VIEW_TYPE
import org.json.JSONObject

class JTCJsonParser(val data : JSONObject) {


    private val viewDataParsers : ArrayList<JTCViewDataParser> = arrayListOf()

    init {
        viewDataParsers.add(JTCColumParser)
        viewDataParsers.add(JTCLHorzSliderParser)
        viewDataParsers.add(JTCListParser)
        viewDataParsers.add(JTCUrlImageParser)
    }

    fun addViewDataParser(parser : JTCViewDataParser) {
        viewDataParsers.add(parser)
    }

    open fun getViewDataParser(key : String) : JTCViewDataParser? {
        return viewDataParsers.find {
            it.canParse(key)
        }
    }

    fun parse() : JTCViewData?{
        val rootViewType = data.get(JTC_VIEW_TYPE) as String
        return getViewDataParser(rootViewType)?.parse(data.get(JTC_VIEW_DATA) as JSONObject)
    }

}