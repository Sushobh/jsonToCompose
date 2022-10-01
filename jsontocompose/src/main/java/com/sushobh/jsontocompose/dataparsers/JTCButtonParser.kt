package com.sushobh.jsontocompose.dataparsers

import com.sushobh.jsontocompose.JTCViewDataParser
import com.sushobh.jsontocompose.viewdata.JTCButtonData
import com.sushobh.jsontocompose.viewdata.JTCTextData
import com.sushobh.jsontocompose.viewdata.JTCViewData
import com.sushobh.jsontocompose.viewdata.JTC_TEXT
import com.sushobh.jsontocompose.viewtypes.JTC_BUTTON
import com.sushobh.jsontocompose.viewtypes.JTC_VIEW_PROPS
import org.json.JSONObject

object JTCButtonParser : JTCViewDataParser {
    override fun parse(jsonObject: JSONObject): JTCViewData {
        val props = JTCPropParser(jsonObject.get(JTC_VIEW_PROPS) as JSONObject).parse()
        val data = jsonObject.get(JTC_TEXT) as String
        return JTCButtonData("",props,data)
    }

    override fun canParse(key: String): Boolean {
        return key == JTC_BUTTON
    }
}