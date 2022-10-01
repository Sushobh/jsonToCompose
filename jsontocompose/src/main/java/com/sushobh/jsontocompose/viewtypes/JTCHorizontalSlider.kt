@file:OptIn(ExperimentalPagerApi::class)

package com.sushobh.jsontocompose.viewtypes

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.sushobh.jsontocompose.ViewDrawer
import com.sushobh.jsontocompose.propparser.updateModifier
import com.sushobh.jsontocompose.viewdata.JTCHorizontalSliderData
import com.sushobh.jsontocompose.viewdata.JTCUrlImageData
import com.sushobh.jsontocompose.viewdata.JTCViewData
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

class JTCHorizontalSlider(data : JTCHorizontalSliderData) : JTCViewType<JTCHorizontalSliderData>(data) {
    @Composable
    override fun View()  {
        val pagerState = PagerState(currentPage = 0)
        LaunchedEffect(Unit) {
            while(true) {
                yield()
                delay(2000)
                pagerState.animateScrollToPage((pagerState.currentPage + 1) % (pagerState.pageCount))
            }
        }
        HorizontalPager(count = data.data.size, Modifier.updateModifier(data.viewProps), state = pagerState) { page ->
            ViewDrawer(data.data[page]).draw()
        }
    }

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCHorizontalSliderData
    }
}