# kwiet

![](https://travis-ci.org/louth/kwiet.svg?branch=master) [ ![](https://api.bintray.com/packages/louth/maven/kwiet/images/download.svg) ](https://bintray.com/louth/maven/kwiet/_latestVersion)

Kotlin implementation for voice technologies.

This project began as a fork of 
[https://github.com/Ticketmaster/actions-on-google-kotlin](https://github.com/Ticketmaster/actions-on-google-kotlin)

## Getting Started

```
repositories {
  jcenter()
}

dependencies {
  compile 'au.com.louth:kwiet-actions-sdk:0.2'
}
```

## Usage

### Google ActionsSDK on AWS Lambda

```

fun mainHandler(request: AppRequest) = simpleResponse {
    textToSpeech = "Hello - using kwiet-actions-sdk-0.2"
}

fun quitHandler(request: AppRequest) = finalResponse {
    textToSpeech = "Goodbye"
}

fun echoHandler(request: AppRequest) = simpleResponse {
    textToSpeech = request.getArg("text")
}

val handlers = mapOf(
        StandardIntent.MAIN to ::mainHandler,
        StandardIntent.CANCEL to ::quitHandler,
        StandardIntent.TEXT to ::echoHandler)

fun handleActionRequest(request: AppRequest) = handleRequest(handlers, request)

```

