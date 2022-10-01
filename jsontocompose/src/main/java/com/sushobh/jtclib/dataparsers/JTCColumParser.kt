package com.sushobh.jtclib.dataparsers

import com.sushobh.jtclib.JTCCustomDataHandler
import com.sushobh.jtclib.JTCJsonParser
import com.sushobh.jtclib.JTCViewDataParser
import com.sushobh.jtclib.viewdata.JTCColumnData
import com.sushobh.jtclib.viewdata.JTCViewData
import com.sushobh.jtclib.viewdata.JTC_COLUMN_DATA
import com.sushobh.jtclib.viewtypes.JTC_COLUMN
import com.sushobh.jtclib.viewtypes.JTC_ORIENTATION
import com.sushobh.jtclib.viewtypes.JTC_VIEW_PROPS
import org.json.JSONArray
import org.json.JSONObject

object JTCColumParser : JTCViewDataParser {
    override fun parse(jsonObject: JSONObject,customHandler: JTCCustomDataHandler?): JTCViewData {
        val props = JTCPropParser(jsonObject.get(JTC_VIEW_PROPS) as JSONObject).parse()
        val children = arrayListOf<JTCViewData>()
        val orientation = (jsonObject.get(JTC_ORIENTATION) as String).toInt()
        val data = jsonObject.get(JTC_COLUMN_DATA) as JSONArray
        for(i in 0..data.length()-1){
             val child = JTCJsonParser(data.get(i) as JSONObject,customHandler).parse()
             child?.let { children.add(child) }
        }
        return JTCColumnData("",props,children,orientation)
    }

    override fun canParse(key: String): Boolean {
        return key == JTC_COLUMN
    }
}