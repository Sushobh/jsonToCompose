@file:OptIn(ExperimentalPagerApi::class)

package com.sushobh.jtclib.viewtypes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.sushobh.jtclib.JTCCustomViewDataHandler
import com.sushobh.jtclib.JTCJsonToCompose
import com.sushobh.jtclib.propparser.updateModifier
import com.sushobh.jtclib.viewdata.JTCHorizontalSliderData
import com.sushobh.jtclib.viewdata.JTCViewData
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

class JTCHorizontalSlider(data : JTCHorizontalSliderData,viewDataHandler: JTCCustomViewDataHandler?) :
    JTCViewType<JTCHorizontalSliderData>(data,viewDataHandler) {
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
            JTCJsonToCompose(data.data[page],viewDataHandler).draw()
        }
    }

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCHorizontalSliderData
    }
}