package com.sushobh.jtclib.viewtypes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sushobh.jtclib.JTCCustomViewDataHandler
import com.sushobh.jtclib.JTCJsonToCompose
import com.sushobh.jtclib.propparser.updateModifier
import com.sushobh.jtclib.viewdata.JTCListData
import com.sushobh.jtclib.viewdata.JTCViewData

class JTCList(data : JTCListData,viewDataHandler: JTCCustomViewDataHandler?) : JTCViewType<JTCListData>(data,viewDataHandler) {
    @Composable
    override fun View()  {
           if(data.orientation == 0){
              LazyColumn(modifier = Modifier.updateModifier(data.viewProps)) {
                  items(data.listData.size) { index ->
                      JTCJsonToCompose(data.listData[index],viewDataHandler).draw()
                  }
              }
          }
          else {
               LazyRow(modifier = Modifier.updateModifier(data.viewProps)) {
                   items(data.listData.size) { index ->
                       JTCJsonToCompose(data.listData[index],viewDataHandler).draw()
                   }
               }
          }
    }

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCListData
    }
}