package com.sushobh.jsontocompose.dataparsers

import com.sushobh.jsontocompose.viewdata.JTCViewProps
import org.json.JSONObject

class JTCPropParser(val data : JSONObject) {
    fun parse() : JTCViewProps? {
        return JTCViewProps()
    }
}