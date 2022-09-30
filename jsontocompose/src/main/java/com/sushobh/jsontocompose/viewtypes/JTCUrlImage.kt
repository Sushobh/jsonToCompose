package com.sushobh.jsontocompose.viewtypes

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.sushobh.jsontocompose.propparser.PropToModifier
import com.sushobh.jsontocompose.viewdata.JTCColumnData
import com.sushobh.jsontocompose.viewdata.JTCUrlImageData
import com.sushobh.jsontocompose.viewdata.JTCViewData

class JTCUrlImage(data : JTCUrlImageData) : JTCViewType<JTCUrlImageData>(data) {

    @Composable
    override fun View() = AsyncImage(
        model = data.url,
        contentDescription = null,
        modifier = PropToModifier.getModifier(data.viewProps)
    )


    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCUrlImageData
    }
}