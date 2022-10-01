package com.sushobh.jsontocompose.customjtc

import com.sushobh.jsontocompose.JTCCustomDataHandler
import com.sushobh.jsontocompose.JTCViewDataParser
import com.sushobh.jsontocompose.dataparsers.JTCPropParser
import com.sushobh.jsontocompose.viewdata.JTCButtonData
import com.sushobh.jsontocompose.viewdata.JTCViewData
import com.sushobh.jsontocompose.viewdata.JTC_TEXT
import com.sushobh.jsontocompose.viewtypes.JTC_BUTTON
import com.sushobh.jsontocompose.viewtypes.JTC_VIEW_PROPS
import org.json.JSONObject

object JTCUpdateKycParser : JTCViewDataParser {
    override fun parse(jsonObject: JSONObject,customHandler: JTCCustomDataHandler?): JTCViewData {
        val props = JTCPropParser(jsonObject.get(JTC_VIEW_PROPS) as JSONObject).parse()
        val message = jsonObject.get("message") as String
        val buttonText = jsonObject.get("buttonText") as String
        return JTCUpdateKycData("", props, message, buttonText)
    }

    override fun canParse(key: String): Boolean {
        return key == JTC_UPDATE_KYC
    }
}