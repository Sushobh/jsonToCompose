package com.sushobh.jsontocompose.propparser

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.sushobh.jsontocompose.viewdata.JTCViewProps

const val JTC_VIEW_PROPS = "JTC_VIEW_PROPS"
fun Modifier.updateModifier(viewProps: JTCViewProps?) : Modifier {
    var modifier = this
    viewProps?.let { props ->
        if(props.setHeight)
        {
            modifier = Modifier.height(Dp(props.height))
        }
        if(props.setWidth) {
            modifier = Modifier.width(Dp(props.width))
        }
        if(props.setMargin){
            modifier = Modifier.padding(Dp(props.margin))
        }
        if(props.setLeftMargin){
            modifier = Modifier.padding(start = Dp(props.leftMargin))
        }
        if(props.setRightMargin){
            modifier = Modifier.padding(start = Dp(props.rightMargin))
        }

        if(props.setBackgroundColor){
            props.backgroundColor?.let {
                modifier = Modifier.background(color = Color(android.graphics.Color.parseColor(it)))
            }
        }
    }
    return modifier
}
