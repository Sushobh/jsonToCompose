package com.sushobh.jtclib.dataparsers

import com.sushobh.jtclib.JTCCustomDataHandler
import com.sushobh.jtclib.JTCViewDataParser
import com.sushobh.jtclib.viewdata.JTCButtonData
import com.sushobh.jtclib.viewdata.JTCViewData
import com.sushobh.jtclib.viewdata.JTC_TEXT
import com.sushobh.jtclib.viewtypes.JTC_BUTTON
import com.sushobh.jtclib.viewtypes.JTC_VIEW_PROPS
import org.json.JSONObject

object JTCButtonParser : JTCViewDataParser {
    override fun parse(jsonObject: JSONObject,customHandler: JTCCustomDataHandler?): JTCViewData {
        val props = JTCPropParser(jsonObject.get(JTC_VIEW_PROPS) as JSONObject).parse()
        val data = jsonObject.get(JTC_TEXT) as String
        return JTCButtonData("",props,data)
    }

    override fun canParse(key: String): Boolean {
        return key == JTC_BUTTON
    }
}