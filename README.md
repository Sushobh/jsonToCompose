# jsonToCompose

## Trying to create jetpack compose views driven by a  JSON structure.

Here is a demo

https://user-images.githubusercontent.com/20350751/193395232-8ccb07ae-c91c-44ec-ae59-76fb001b9c4a.mp4

The json for the above view is this

https://github.com/Sushobh/jsonToCompose/blob/master/jsontocompose/src/main/assets/example_full.json

## Download

In your project level gradle file, add this

```kotlin
allprojects {
   repositories {
    ......
	  maven { url 'https://jitpack.io' }
	}
   }
```
If you are declaring repository list in settings.gradle, add it like this

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ......
        maven { url 'https://jitpack.io' }
    }
}
```

And then add the dependency in your app level gradle file
```kotlin
dependencies {
 implementation 'com.github.Sushobh:jsonToCompose:0b1cb70077'
}
```

## Features
- The library converts JSON into an intermediate format, which is then parsed to create compose views.
- The library by default supports columns,rows, lists(horizontal and vertical),horizontal sliders,texts,buttons.
- The library also parses **viewprops**, i.e. properties which define how the is laid out. These viewprops
  are parsed from JSON. These viewprops can be used to customize views based on JSON.
- All views get access to viewprops, you can handle the viewprops yourself to customize the UI or let the *updateModifier* extension method do it for you.
- The *updateModifier* currently only takes care of height,width,margin and background color.

## JSON Structure
Custom views can define their own JSON substrcture but will have to wrapped up in a predefined container. For example this is the structure for a column.
**JTC_COLUMN_DATA**, is where the contents of data will reside.

  ```json
  {
    "JTC_VIEW_TYPE" : "JTC_COLUMN",
    "JTC_VIEW_DATA" : {
      "JTC_VIEW_PROPS" : {



      },
      "JTC_ORIENTATION" : "1",
      "JTC_COLUMN_DATA" : [
          {
              "JTC_VIEW_TYPE": "JTC_TEXT",
              "JTC_VIEW_DATA": {
                "JTC_VIEW_PROPS": {
                  "setMargin": true,
                  "margin": "15f"
                },
                "JTC_ORIENTATION": "0",
                "JTC_TEXT": "Item 1"
              }
            },
            
            {
              "JTC_VIEW_TYPE": "JTC_TEXT",
              "JTC_VIEW_DATA": {
                "JTC_VIEW_PROPS": {
                  "setMargin": true,
                  "margin": "15f"
                },
                "JTC_ORIENTATION": "0",
                "JTC_TEXT": "Item 2"
              }
            }
      ]
    }
  }
  ```
  
**JTC_VIEW_TYPE** is required, it helps differeniate between different view types.

**JTC_VIEW_DATA** is required, it helps to contain **viewprops** and your custom data.
  Inside of **JTC_VIEW_DATA**, you can define your attributes and properties.

**JTC_VIEW_PROPS** are parsed and passed down as an object to your customviews, more on this later.


## Creating a custom view

If you look at the demo video, you will see that it has a update kyc prompt with a text followed by a button. 
This was created as a custom view, the source code is available for this custom view is available here
https://github.com/Sushobh/jsonToCompose/tree/master/app/src/main/java/com/sushobh/jsontocompose/customjtc.

There are three steps, to creating a custom view 

- Define json structure.
- Create a data holder class to represent the structure.
- Create a parser which can convert JSON to data holder class.
- Create a viewtype which can render compose view based on the dataholder.

#### Define json structure.
 In case of the update kyc prompt, we only need two attributes. 1) The message. 2) The text of the button. So our JSON structure will look like this
 
 ```json
  {
        "JTC_VIEW_TYPE": "JTC_UPDATE_KYC",
        "JTC_VIEW_DATA": {
          "JTC_VIEW_PROPS": {
            "setBackgroundColor": true,
            "backgroundColor": "#ede7f6"
          },
          "message" : "Have you updated your KYC? Do it now to get 100 reward points!",
          "buttonText" : "Update KYC"
        }
      }
 ```
 
 #### Create a data holder class to represent the structure.
 
 ```kotlin
    const val JTC_UPDATE_KYC_DATA = "JTC_UPDATE_KYC_DATA"
    const val JTC_UPDATE_KYC = "JTC_UPDATE_KYC"
    class JTCUpdateKycData(info : String,viewProps : JTCViewProps?,
                           val message : String,val buttonText : String) : JTCViewData(info,viewProps) {
                           
    }
 ```
 
 ####  Create a parser which can convert JSON to data holder class.
 
 ```kotlin
 object JTCUpdateKycParser : JTCViewDataParser {
    override fun parse(jsonObject: JSONObject,customHandler: JTCCustomDataHandler?): JTCViewData {
        val props = JTCPropParser(jsonObject.get(JTC_VIEW_PROPS) as JSONObject).parse()
        val message = jsonObject.get("message") as String
        val buttonText = jsonObject.get("buttonText") as String
        return JTCUpdateKycData("", props, message, buttonText)
    }

    override fun canParse(key: String): Boolean {
        return key == JTC_UPDATE_KYC
    }
}
 ```
 
#### Create a viewtype which can render compose view based on the dataholder.

```kotlin
class JTCUpdateKyc(data : JTCUpdateKycData) : JTCViewType<JTCUpdateKycData>(data) {

    @Composable
    override fun View() {
         Column(Modifier.updateModifier(data.viewProps)) {
             Text(text = data.message, modifier = Modifier.padding(Dp(10f)))
             Button(modifier = Modifier.padding(Dp(10f)),onClick = {}, content = {
                 Text(text = data.buttonText)
             })
         }
    }

    override fun canDraw(jtcViewType: JTCViewData): Boolean {
        return jtcViewType is JTCUpdateKycData
    }
}
```
 
 ## Using the custom view.
  
 The custom view created above has been used here
 https://github.com/Sushobh/jsonToCompose/blob/master/app/src/main/java/com/sushobh/jsontocompose/MainActivity.kt
 
 Using the custom view involves two steps.
 - Create a custom data parser and pass it to the data parser.
 - Create a custom view data handler and pass it to JTCtoJSONCompose
 
 #### Create a custom data parser and pass it to the data parser.
 
 ```kotlin
//Create custom data parser
val customDataHandler = object : JTCCustomDataHandler {
    override fun handle(key: String): JTCViewDataParser? {
        return when(key){
            JTC_UPDATE_KYC ->  JTCUpdateKycParser
            else -> { null }
        }
    }
}

//Parse data from json first
val jtcDataParser = JTCJsonParser(loadJsonObject("example_full.json",this),customDataHandler)

val data = jtcDataParser.parse()
 ```
 
 Now that we have data ready, we can use it to create compose views.
 
 #### Create a custom view data handler and pass it to JTCtoJSONCompose
 
 ```kotlin
var jtcView : JTCJsonToCompose? = null

//Create custom view handler, this handler can be null if no custom views are needed.
val customViewHandler = object : JTCCustomViewDataHandler {
  override fun handle(viewData: JTCViewData): JTCViewType<*>? {
      return  when(viewData) {

          //Update kyc is a custom view, so we handle it
          is JTCUpdateKycData -> JTCUpdateKyc(viewData)
          else -> {
              null
          }
      }
  }
}

//Initialize view
    data?.let {
        jtcView =  JTCJsonToCompose(data, customViewHandler)
    }
 ```
 
  ## About View Props
  ViewProps only have a limited number of attributes. So if there is a property that you would want to have in a custom view, add them to
  the **JTC_VIEW_DATA** and handle them in the custom view. For the attirbutes that are part of ViewProps, the usage is as follows
  
  ```json
 "JTC_VIEW_PROPS": {
  "setBackgroundColor": true,
  "backgroundColor": "#ede7f6"
 }
  ```
  
  Each attribute has an associated attribute starting with "set" which needs to be true. The "set" attribute is added to differentiate between default    float/boolean/int values (which are 0 or false) and user set values. 
  
  ## What's next? 
  
- [x] Support custom views.  
- [ ] Add support for click events.
- [ ] Support more viewprops.


  
      
      
     
  
