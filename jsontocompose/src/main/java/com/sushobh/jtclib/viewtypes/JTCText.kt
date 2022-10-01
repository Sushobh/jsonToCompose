package com.sushobh.jtclib.viewtypes

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.sushobh.jtclib.propparser.updateModifier
import com.sushobh.jtclib.viewdata.JTCTextData
import com.sushobh.jtclib.viewdata.JTCViewData

class JTCText(data : JTCTextData) : JTCViewType<JTCTextData>(data){

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCTextData
    }

    @Composable
    override fun View() {
        Text(text = data.data,Modifier.updateModifier(data.viewProps), fontWeight = FontWeight.Bold)
    }
}