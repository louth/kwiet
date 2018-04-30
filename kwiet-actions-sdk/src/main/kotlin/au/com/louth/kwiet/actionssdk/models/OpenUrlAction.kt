package au.com.louth.kwiet.actionssdk.models

data class OpenUrlAction(var url: String,
                         var androidApp: AndroidApp,
                         var urlTypeHint: UrlTypeHint)

data class AndroidApp(var packageName: String,
                      var versions : MutableList<VersionFilter> = mutableListOf())

data class VersionFilter(var minVersion : Number,
                         var maxVersion : Number)