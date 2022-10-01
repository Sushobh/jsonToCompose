package com.sushobh.jsontocompose.viewtypes

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sushobh.jsontocompose.propparser.updateModifier
import com.sushobh.jsontocompose.viewdata.JTCButtonData
import com.sushobh.jsontocompose.viewdata.JTCColumnData
import com.sushobh.jsontocompose.viewdata.JTCViewData

class JTCButton(data : JTCButtonData) : JTCViewType<JTCButtonData>(data) {

    @Composable
    override fun View() {
        Button(modifier = Modifier.updateModifier(data.viewProps),onClick = {}, content = {
            Text(text = data.text)
        })
    }

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCButtonData
    }
}