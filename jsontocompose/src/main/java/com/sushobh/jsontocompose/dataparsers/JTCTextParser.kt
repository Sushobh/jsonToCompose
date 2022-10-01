package com.sushobh.jsontocompose.dataparsers

import com.sushobh.jsontocompose.JTCCustomDataHandler
import com.sushobh.jsontocompose.JTCViewDataParser
import com.sushobh.jsontocompose.viewdata.*
import com.sushobh.jsontocompose.viewtypes.JTC_URL_IMAGE
import com.sushobh.jsontocompose.viewtypes.JTC_VIEW_PROPS
import org.json.JSONObject

object JTCTextParser : JTCViewDataParser {
    override fun parse(jsonObject: JSONObject,customHandler: JTCCustomDataHandler?): JTCViewData {
        val props = JTCPropParser(jsonObject.get(JTC_VIEW_PROPS) as JSONObject).parse()
        val data = jsonObject.get(JTC_TEXT) as String
        return JTCTextData("",props,data)
    }

    override fun canParse(key: String): Boolean {
        return key == JTC_TEXT
    }
}