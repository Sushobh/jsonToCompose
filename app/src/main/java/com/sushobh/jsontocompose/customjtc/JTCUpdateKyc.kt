package com.sushobh.jsontocompose.customjtc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.sushobh.jsontocompose.propparser.updateModifier
import com.sushobh.jsontocompose.viewdata.JTCButtonData
import com.sushobh.jsontocompose.viewdata.JTCViewData
import com.sushobh.jsontocompose.viewtypes.JTCViewType

class JTCUpdateKyc(data : JTCUpdateKycData) : JTCViewType<JTCUpdateKycData>(data) {

    @Composable
    override fun View() {
         Column(Modifier.updateModifier(data.viewProps)) {
             Text(text = data.message, modifier = Modifier.padding(Dp(10f)))
             Button(modifier = Modifier.padding(Dp(10f)),onClick = {}, content = {
                 Text(text = data.buttonText)
             })
         }
    }

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCUpdateKycData
    }
}