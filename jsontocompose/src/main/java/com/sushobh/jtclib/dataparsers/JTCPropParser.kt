package com.sushobh.jtclib.dataparsers

import com.sushobh.jtclib.viewdata.JTCViewProps
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONObject

class JTCPropParser(val data : JSONObject) {
    fun parse() : JTCViewProps? {
        return Json.decodeFromString(data.toString())
    }
}