package com.sushobh.jtclib

import com.sushobh.jtclib.viewdata.JTCViewData
import com.sushobh.jtclib.viewtypes.JTCViewType

interface JTCCustomViewDataHandler {
    fun handle(viewData : JTCViewData) : JTCViewType<*>?
}