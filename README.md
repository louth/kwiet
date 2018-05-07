# kwiet

Kotlin implementation for voice technologies.

![](https://travis-ci.org/louth/kwiet.svg?branch=master) [![Coverage Status](https://coveralls.io/repos/github/louth/kwiet/badge.svg?branch=master)](https://coveralls.io/github/louth/kwiet?branch=master) [ ![](https://api.bintray.com/packages/louth/maven/kwiet/images/download.svg) ](https://bintray.com/louth/maven/kwiet/_latestVersion) 

## Getting Started

```
repositories {
  jcenter()
}

dependencies {
  compile 'au.com.louth:kwiet-actions-sdk:0.3'
}
```

## Usage

### Google ActionsSDK on AWS Lambda

```

fun mainHandler(request: AppRequest, context: Context) = simpleResponse {
    textToSpeech = "Hello world"
}

fun echoHandler(request: AppRequest) = simpleResponse {
    textToSpeech = request.getArg("text")
}

fun quitHandler() = finalResponse {
    textToSpeech = "Goodbye"
}

val handlers = mapOf(
        StandardIntent.MAIN to ::mainHandler,
        StandardIntent.TEXT to ::echoHandler,
        StandardIntent.CANCEL to ::quitHandler)

fun handleActionRequest(request: AppRequest) = handleLambdaRequest(handlers, request)

```

### Code of Conduct

Please note that this project is released with a [Contributor Code of Conduct](CODE_OF_CONDUCT.md).
By contributing to this project (commenting or opening PR/Issues etc) you are agreeing to follow this conduct, so please
take the time to read it. 

### Acknowledgment

This project began as a fork of
[https://github.com/Ticketmaster/actions-on-google-kotlin](https://github.com/Ticketmaster/actions-on-google-kotlin)

### License

kwiet is licensed under the Apache 2.0 License. See [LICENSE](LICENSE) for details.

Copyright (c) 2018, Andrew Louth and [Contributors](https://github.com/louth/kwiet/graphs/contributors)