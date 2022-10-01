@file:Suppress("IllegalIdentifier")

package com.sushobh.jsontocompose

import android.content.res.AssetManager
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sushobh.jsontocompose.viewdata.*
import org.json.JSONObject
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class JTCJsonParserTest {


    val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun testAssetFolderJsonIsLoaded(){
        Assert.assertNotNull(loadJsonObject("testbasic.json"))
    }

    @Test
    fun checkColumnData(){
        val data = loadJsonObject("test_column.json")
        val jtcJsonParser = JTCJsonParser(data)
        val viewData = jtcJsonParser.parse() as JTCColumnData
        Assert.assertEquals(0,viewData.data.size)
        Assert.assertEquals(1,viewData.orientation)
    }

    @Test
    fun checkListData(){
        val data = loadJsonObject("test_list.json")
        val jtcJsonParser = JTCJsonParser(data)
        val viewData = jtcJsonParser.parse() as JTCListData
        Assert.assertEquals(0,viewData.listData.size)
        Assert.assertEquals(1,viewData.orientation)
    }

    @Test
    fun checkHorzSliderData(){
        val data = loadJsonObject("test_horzs.json")
        val jtcJsonParser = JTCJsonParser(data)
        val viewData = jtcJsonParser.parse() as JTCHorizontalSliderData
        Assert.assertEquals(3,viewData.data.size)
    }


    @Test
    fun checkUrlImageData(){
        val data = loadJsonObject("test_urlimage.json")
        val jtcJsonParser = JTCJsonParser(data)
        val viewData = jtcJsonParser.parse() as JTCUrlImageData
        Assert.assertEquals("https://miro.medium.com/max/720/0*H4LhP76j0NT_9Gq3",viewData.url)
    }

    @Test
    fun checkTestData(){
        val data = loadJsonObject("test_text.json")
        val jtcJsonParser = JTCJsonParser(data)
        val viewData = jtcJsonParser.parse() as JTCTextData
        Assert.assertEquals("Hello World bro",viewData.data)
    }

    @Test
    fun checkButtonData(){
        val data = loadJsonObject("test_button.json")
        val jtcJsonParser = JTCJsonParser(data)
        val viewData = jtcJsonParser.parse() as JTCButtonData
        Assert.assertEquals("Update KYC",viewData.text)
    }

    @Test
    fun nestedDataTest(){
        val data = loadJsonObject("test_nesteddata.json")
        val jtcJsonParser = JTCJsonParser(data)
        val viewData = jtcJsonParser.parse() as JTCColumnData
        Assert.assertTrue(viewData.data.size == 3)

        Assert.assertEquals(3,
            (viewData.data.find { it is JTCHorizontalSliderData } as JTCHorizontalSliderData).data.size)
        Assert.assertEquals(2,(viewData.data.find { it is JTCListData } as JTCListData).listData.size)
    }


    fun loadJsonObject(fileName: String) : JSONObject{
        val jsonDataString = appContext.assets.readAssetsFile(fileName)
        return JSONObject(jsonDataString)
    }

    fun AssetManager.readAssetsFile(fileName : String): String {
        val stream = open(fileName)
        val string = stream.bufferedReader().readText()
        stream.close()
        return string
    }


}