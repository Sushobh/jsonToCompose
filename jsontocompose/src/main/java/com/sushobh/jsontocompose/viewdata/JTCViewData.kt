package com.sushobh.jsontocompose.viewdata

open class JTCViewData(val info : String,val viewProps : JTCViewProps?) {

}


class JTCViewProps {
    val height : Float = 0f
    val width : Float = 0f
    val topMargin : Float = 0f
    val bottomMargin : Float = 0f
    val leftMargin : Float = 0f
    val rightMargin : Float = 0f
    val margin : Float = 0f
    val padding : Float = 0f
    val leftPadding : Float = 0f
    val rightPadding : Float = 0f
    val topPadding : Float = 0f
    val bottomPadding : Float = 0f
    val clickable : Boolean = false
}