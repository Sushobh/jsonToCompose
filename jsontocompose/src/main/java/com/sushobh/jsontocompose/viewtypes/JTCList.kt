package com.sushobh.jsontocompose.viewtypes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.sushobh.jsontocompose.ViewDrawer
import com.sushobh.jsontocompose.propparser.PropToModifier
import com.sushobh.jsontocompose.viewdata.JTCColumnData
import com.sushobh.jsontocompose.viewdata.JTCListData
import com.sushobh.jsontocompose.viewdata.JTCViewData

class JTCList(data : JTCListData) : JTCViewType<JTCListData>(data) {
    @Composable
    override fun View()  {
           if(data.orientation == 0){
              LazyColumn(modifier = PropToModifier.getModifier(data.viewProps)) {
                  items(data.listData.size) { index ->
                      ViewDrawer(data.listData[index]).draw()
                  }
              }
          }
          else {
               LazyRow(modifier = PropToModifier.getModifier(data.viewProps)) {
                   items(data.listData.size) { index ->
                       ViewDrawer(data.listData[index]).draw()
                   }
               }
          }
    }

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCListData
    }
}