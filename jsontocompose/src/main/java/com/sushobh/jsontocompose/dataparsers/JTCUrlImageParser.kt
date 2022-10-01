package com.sushobh.jsontocompose.dataparsers

import com.sushobh.jsontocompose.JTCCustomDataHandler
import com.sushobh.jsontocompose.JTCJsonParser
import com.sushobh.jsontocompose.JTCViewDataParser
import com.sushobh.jsontocompose.viewdata.JTCListData
import com.sushobh.jsontocompose.viewdata.JTCUrlImageData
import com.sushobh.jsontocompose.viewdata.JTCViewData
import com.sushobh.jsontocompose.viewdata.JTC_IMAGE_URL
import com.sushobh.jsontocompose.viewtypes.*
import org.json.JSONArray
import org.json.JSONObject

object JTCUrlImageParser : JTCViewDataParser {
    override fun parse(jsonObject: JSONObject,customHandler: JTCCustomDataHandler?): JTCViewData {
        val props = JTCPropParser(jsonObject.get(JTC_VIEW_PROPS) as JSONObject).parse()
        val data = jsonObject.get(JTC_IMAGE_URL) as String
        return JTCUrlImageData("",props,data)
    }

    override fun canParse(key: String): Boolean {
        return key == JTC_URL_IMAGE
    }
}