package com.sushobh.jsontocompose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.sushobh.jsontocompose.viewdata.*
import com.sushobh.jsontocompose.viewtypes.*

class ViewDrawer(val jtcViewData: JTCViewData) {

    fun getViewDrawer(viewData: JTCViewData) : JTCViewType<*>? {
       return when(viewData){
           is JTCColumnData -> JTCColumn(viewData)
           is JTCUrlImageData -> JTCUrlImage(viewData)
           is JTCListData -> JTCList(viewData)
           is JTCHorizontalSliderData -> JTCHorizontalSlider(viewData)
           else -> {return null}
       }

    }

    @Composable
    fun draw() {
        getViewDrawer(jtcViewData)?.View()
    }

}