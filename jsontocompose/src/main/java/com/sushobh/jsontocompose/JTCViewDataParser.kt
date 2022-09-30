package com.sushobh.jsontocompose

import com.sushobh.jsontocompose.viewdata.JTCViewData
import org.json.JSONObject

interface JTCViewDataParser {
    fun parse( jsonObject: JSONObject) : JTCViewData
    fun canParse(key : String) : Boolean
}