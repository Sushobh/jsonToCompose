package com.sushobh.jtclib.dataparsers

import com.sushobh.jtclib.JTCCustomDataHandler
import com.sushobh.jtclib.JTCJsonParser
import com.sushobh.jtclib.JTCViewDataParser
import com.sushobh.jtclib.viewdata.JTCHorizontalSliderData
import com.sushobh.jtclib.viewdata.JTCViewData
import com.sushobh.jtclib.viewdata.JTC_HORZ_SLIDER_DATA
import com.sushobh.jtclib.viewtypes.JTC_HORIZONTAL_SLIDER
import com.sushobh.jtclib.viewtypes.JTC_VIEW_PROPS
import org.json.JSONArray
import org.json.JSONObject

object JTCLHorzSliderParser : JTCViewDataParser {
    override fun parse(jsonObject: JSONObject,customHandler: JTCCustomDataHandler?): JTCViewData {
        val props = JTCPropParser(jsonObject.get(JTC_VIEW_PROPS) as JSONObject).parse()
        val children = arrayListOf<JTCViewData>()
        val data = jsonObject.get(JTC_HORZ_SLIDER_DATA) as JSONArray
        for(i in 0..data.length()-1){
            val child = JTCJsonParser(data.get(i) as JSONObject,customHandler).parse()
            child?.let { children.add(child) }
        }
        return JTCHorizontalSliderData("",props,children)
    }

    override fun canParse(key: String): Boolean {
        return key == JTC_HORIZONTAL_SLIDER
    }
}