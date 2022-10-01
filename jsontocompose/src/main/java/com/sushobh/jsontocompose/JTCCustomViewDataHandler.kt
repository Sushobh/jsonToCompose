package com.sushobh.jsontocompose

import com.sushobh.jsontocompose.viewdata.JTCViewData
import com.sushobh.jsontocompose.viewtypes.JTCViewType

interface JTCCustomViewDataHandler {
    fun handle(viewData : JTCViewData) : JTCViewType<*>?
}