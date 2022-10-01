package com.sushobh.jtclib.viewdata

import kotlinx.serialization.Serializable

open class JTCViewData(val info : String,val viewProps : JTCViewProps?) {

}

@Serializable
class JTCViewProps {
    val height : Float = 0f
    val setHeight : Boolean = false

    val width : Float = 0f
    val setWidth : Boolean = false

    val margin : Float = 0f
    val setMargin : Boolean = false

    val leftMargin : Float = 0f
    val setLeftMargin : Boolean = false

    val rightMargin : Float = 0f
    val setRightMargin : Boolean = false

    val setBackgroundColor : Boolean = false
    val backgroundColor : String? = null

    val imageProps : ImageProps? = null
}

@Serializable
data class ImageProps(val strechToFit : Boolean = false)