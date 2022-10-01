package com.sushobh.jsontocompose.viewtypes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sushobh.jsontocompose.ViewDrawer

import com.sushobh.jsontocompose.propparser.updateModifier
import com.sushobh.jsontocompose.viewdata.JTCColumnData
import com.sushobh.jsontocompose.viewdata.JTCUrlImageData
import com.sushobh.jsontocompose.viewdata.JTCViewData


class JTCColumn(data : JTCColumnData) : JTCViewType<JTCColumnData>(data) {

    @Composable
    override fun View() {
        if(data.orientation == 0){
            Column(modifier = Modifier.updateModifier(data.viewProps)) {
                data.data.forEach {
                    ViewDrawer(it).draw()
                }
            }
        }
        else {
            Row(modifier = Modifier.updateModifier(data.viewProps)) {
                data.data.forEach {
                    ViewDrawer(it).draw()
                }
            }
        }

    }


    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCColumnData
    }
}