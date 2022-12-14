package com.sushobh.jsontocompose.customjtc

import com.sushobh.jtclib.JTCCustomDataHandler
import com.sushobh.jtclib.JTCViewDataParser
import com.sushobh.jtclib.dataparsers.JTCPropParser
import com.sushobh.jtclib.viewdata.JTCViewData
import com.sushobh.jtclib.viewtypes.JTC_VIEW_PROPS
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