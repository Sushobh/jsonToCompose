package com.sushobh.jtclib

import androidx.compose.runtime.Composable
import com.sushobh.jtclib.viewdata.*
import com.sushobh.jtclib.viewtypes.*

class JTCJsonToCompose(val jtcViewData: JTCViewData,val viewDataHandler : JTCCustomViewDataHandler? = null) {

    fun getViewDrawer(viewData: JTCViewData) : JTCViewType<*>? {
       viewDataHandler?.let {
           it.handle(viewData)?.let { viewType ->
               return viewType
           }
       }
       return when(viewData){
           is JTCColumnData -> JTCColumn(viewData,viewDataHandler)
           is JTCUrlImageData -> JTCUrlImage(viewData)
           is JTCListData -> JTCList(viewData,viewDataHandler)
           is JTCHorizontalSliderData -> JTCHorizontalSlider(viewData,viewDataHandler)
           is JTCTextData -> JTCText(viewData)
           is JTCButtonData -> JTCButton(viewData)
           else -> {return null}
       }
    }

    @Composable
    fun draw() {
        getViewDrawer(jtcViewData)?.View()
    }

}