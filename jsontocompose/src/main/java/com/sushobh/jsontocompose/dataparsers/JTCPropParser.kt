package com.sushobh.jsontocompose.dataparsers

import com.sushobh.jsontocompose.viewdata.JTCViewProps
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import org.json.JSONObject

class JTCPropParser(val data : JSONObject) {
    fun parse() : JTCViewProps? {
        return Json.decodeFromString(data.toString())
    }
}