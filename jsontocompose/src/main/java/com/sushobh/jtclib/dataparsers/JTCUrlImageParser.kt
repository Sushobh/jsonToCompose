package com.sushobh.jtclib.dataparsers

import com.sushobh.jtclib.JTCCustomDataHandler
import com.sushobh.jtclib.JTCViewDataParser
import com.sushobh.jtclib.viewdata.JTCUrlImageData
import com.sushobh.jtclib.viewdata.JTCViewData
import com.sushobh.jtclib.viewdata.JTC_IMAGE_URL
import com.sushobh.jtclib.viewtypes.JTC_URL_IMAGE
import com.sushobh.jtclib.viewtypes.JTC_VIEW_PROPS
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