package com.sushobh.jsontocompose

import com.sushobh.jsontocompose.viewdata.JTCViewData

interface JTCCustomDataHandler {
    fun handle(key : String) : JTCViewDataParser?
}