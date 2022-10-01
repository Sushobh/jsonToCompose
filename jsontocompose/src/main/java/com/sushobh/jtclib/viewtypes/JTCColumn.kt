package com.sushobh.jtclib.viewtypes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sushobh.jtclib.JTCCustomViewDataHandler
import com.sushobh.jtclib.JTCJsonToCompose
import com.sushobh.jtclib.propparser.updateModifier
import com.sushobh.jtclib.viewdata.JTCColumnData
import com.sushobh.jtclib.viewdata.JTCViewData


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