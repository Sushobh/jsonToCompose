@file:OptIn(ExperimentalPagerApi::class)

package com.sushobh.jsontocompose.viewtypes

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.sushobh.jsontocompose.ViewDrawer
import com.sushobh.jsontocompose.propparser.PropToModifier
import com.sushobh.jsontocompose.viewdata.JTCColumnData
import com.sushobh.jsontocompose.viewdata.JTCHorizontalSliderData
import com.sushobh.jsontocompose.viewdata.JTCListData
import com.sushobh.jsontocompose.viewdata.JTCViewData

class JTCHorizontalSlider(data : JTCHorizontalSliderData) : JTCViewType<JTCHorizontalSliderData>(data) {
    @Composable
    override fun View()  {
        HorizontalPager(count = data.data.size, PropToModifier.getModifier(data.viewProps)) { page ->
            data.data.forEach {
                ViewDrawer(it).draw()
            }
        }
    }

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCHorizontalSliderData
    }
}