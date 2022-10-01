package com.sushobh.jsontocompose.viewtypes

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.sushobh.jsontocompose.propparser.updateModifier
import com.sushobh.jsontocompose.viewdata.JTCListData
import com.sushobh.jsontocompose.viewdata.JTCTextData
import com.sushobh.jsontocompose.viewdata.JTCViewData

class JTCText(data : JTCTextData) : JTCViewType<JTCTextData>(data){

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCTextData
    }

    @Composable
    override fun View() {
        Text(text = data.data,Modifier.updateModifier(data.viewProps), fontWeight = FontWeight.Bold)
    }
}