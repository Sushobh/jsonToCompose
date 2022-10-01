package com.sushobh.jsontocompose.viewtypes

import androidx.compose.runtime.Composable
import com.sushobh.jsontocompose.JTCCustomViewDataHandler
import com.sushobh.jsontocompose.viewdata.JTCViewData


abstract class  JTCViewType<X : JTCViewData>(val data : X,val viewDataHandler: JTCCustomViewDataHandler? = null) {

    @Composable
    abstract fun View()

    abstract fun canDraw(jtcViewType: JTCViewData) : Boolean

}

const val JTC_COLUMN = "JTC_COLUMN"
const val JTC_HORIZONTAL_SLIDER = "JTC_HORIZONTAL_SLIDER"
const val JTC_LIST = "JTC_LIST"
const val JTC_URL_IMAGE = "JTC_URL_IMAGE"
const val JTC_VIEW_TYPE = "JTC_VIEW_TYPE"
const val JTC_VIEW_DATA = "JTC_VIEW_DATA"
const val JTC_VIEW_PROPS = "JTC_VIEW_PROPS"
const val JTC_ORIENTATION = "JTC_ORIENTATION"
const val JTC_TEXT = "JTC_TEXT"
const val JTC_BUTTON = "JTC_BUTTON"

