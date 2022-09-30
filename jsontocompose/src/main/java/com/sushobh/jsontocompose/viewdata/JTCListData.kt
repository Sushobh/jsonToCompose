package com.sushobh.jsontocompose.viewdata

const val JTC_LIST_DATA = "JTC_LIST_DATA"
class JTCListData(info : String,viewProps : JTCViewProps?,val listData : List<JTCViewData>,val orientation : Int) :
    JTCViewData(info,viewProps) {
}