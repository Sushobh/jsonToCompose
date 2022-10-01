package com.sushobh.jsontocompose.customjtc

import com.sushobh.jsontocompose.viewdata.JTCViewData
import com.sushobh.jsontocompose.viewdata.JTCViewProps

const val JTC_UPDATE_KYC_DATA = "JTC_UPDATE_KYC_DATA"
const val JTC_UPDATE_KYC = "JTC_UPDATE_KYC"
class JTCUpdateKycData(info : String,viewProps : JTCViewProps?,
                       val message : String,val buttonText : String) : JTCViewData(info,viewProps) {
}