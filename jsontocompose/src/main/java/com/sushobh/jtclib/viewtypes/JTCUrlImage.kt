package com.sushobh.jtclib.viewtypes


import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import coil.compose.AsyncImage
import com.sushobh.jtclib.propparser.updateModifier

import com.sushobh.jtclib.viewdata.JTCUrlImageData
import com.sushobh.jtclib.viewdata.JTCViewData

class JTCUrlImage(data : JTCUrlImageData) : JTCViewType<JTCUrlImageData>(data) {

    @Composable
    override fun View() {
        if(data.viewProps?.imageProps?.strechToFit == true){
            AsyncImage(
                model = data.url,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .updateModifier(data.viewProps)
                    .fillMaxHeight()
            )
        }
        else {
            AsyncImage(
                model = data.url,
                contentDescription = null,
                modifier = Modifier.updateModifier(data.viewProps)
            )
        }

    }


    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCUrlImageData
    }
}