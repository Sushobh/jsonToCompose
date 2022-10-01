package com.sushobh.jsontocompose.viewtypes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sushobh.jsontocompose.JTCJsonToCompose
import com.sushobh.jsontocompose.JTCCustomViewDataHandler

import com.sushobh.jsontocompose.propparser.updateModifier
import com.sushobh.jsontocompose.viewdata.JTCColumnData
import com.sushobh.jsontocompose.viewdata.JTCViewData


class JTCColumn(data : JTCColumnData,viewDataHandler: JTCCustomViewDataHandler?) : JTCViewType<JTCColumnData>(data,viewDataHandler) {

    @Composable
    override fun View() {
        if(data.orientation == 0){
            Column(modifier = Modifier.updateModifier(data.viewProps)) {
                data.data.forEach {
                    JTCJsonToCompose(it,viewDataHandler).draw()
                }
            }
        }
        else {
            Row(modifier = Modifier.updateModifier(data.viewProps)) {
                data.data.forEach {
                    JTCJsonToCompose(it,viewDataHandler).draw()
                }
            }
        }
    }

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCColumnData
    }
}