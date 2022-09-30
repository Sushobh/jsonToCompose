package com.sushobh.jsontocompose.viewtypes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.sushobh.jsontocompose.ViewDrawer
import com.sushobh.jsontocompose.propparser.PropToModifier
import com.sushobh.jsontocompose.viewdata.JTCColumnData
import com.sushobh.jsontocompose.viewdata.JTCUrlImageData
import com.sushobh.jsontocompose.viewdata.JTCViewData


class JTCColumn(data : JTCColumnData) : JTCViewType<JTCColumnData>(data) {

    @Composable
    override fun View() {
        if(data.orientation == 0){
            Column(modifier = PropToModifier.getModifier(data.viewProps)) {
                data.data.forEach {
                    ViewDrawer(it).draw()
                }
            }
        }
        else {
            Row(modifier = PropToModifier.getModifier(data.viewProps)) {
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