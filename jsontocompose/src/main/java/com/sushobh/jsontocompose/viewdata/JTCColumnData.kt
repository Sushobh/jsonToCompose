package com.sushobh.jsontocompose.viewdata


const val JTC_COLUMN_DATA = "JTC_COLUMN_DATA"
class JTCColumnData(info : String,viewProps : JTCViewProps?,val data : List<JTCViewData>,
                    val orientation : Int) : JTCViewData(info,viewProps) {
}