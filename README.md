# kwiet

![](https://travis-ci.org/louth/kwiet.svg?branch=master) [ ![](https://api.bintray.com/packages/louth/maven/kwiet/images/download.svg) ](https://bintray.com/louth/maven/kwiet/_latestVersion)

Kotlin implementation for voice technologies.

This project began as a fork of 
[https://github.com/Ticketmaster/actions-on-google-kotlin](https://github.com/Ticketmaster/actions-on-google-kotlin)

## Getting Started

```
repositories {
  maven { url  "https://dl.bintray.com/louth/maven" }
}

dependencies {
  compile 'au.com.louth:kwiet-actions:0.1'
}
```

## Usage

### Action on Google - AWS Lambda

```

fun main(app: ActionsSdkApp) =
        app.ask(app.buildRichResponse().addSimpleResponse(speech = "Hello."))

fun cancel(app: ActionsSdkApp) =
        app.tell(speech = "Goodbye.")
        
val actionMap = mutableMapOf(       
        app.STANDARD_INTENTS.MAIN to ::main,
        app.STANDARD_INTENTS.CANCEL to ::cancel)
 
 // this is the lambda message handler
fun handleActionRequest(request: ActionRequest): ActionResponse? {
    val app = buildLambdaApp(request)
        
    app.handleRequest(actionMap)
    
    return app.response.body
}

```

