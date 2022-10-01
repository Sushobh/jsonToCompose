package com.sushobh.jtclib.viewdata


const val JTC_BUTTON_DATA = "JTC_BUTTON_DATA"
class JTCButtonData(info : String,viewProps : JTCViewProps?,
                    val text : String) : JTCViewData(info,viewProps) {
}