package com.sushobh.jtclib.viewtypes

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sushobh.jtclib.propparser.updateModifier
import com.sushobh.jtclib.viewdata.JTCButtonData
import com.sushobh.jtclib.viewdata.JTCViewData

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