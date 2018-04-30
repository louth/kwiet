package au.com.louth.kwiet.actionssdk.models

data class Argument(var name : String? = null,
                    var rawText : String? = null,
                    var textValue: String? = null,
                    var status: Status? = null,
                    var intValue: String? = null,
                    var floatValue: Number? = null,
                    var boolValue: Boolean? = null,
                    var dateTimeValue: DateTime? = null,
                    var placeValue: Location? = null,
                    var extension: Extension? = null,
                    var structuredValue: MutableMap<String, Any>? = null)

data class Status(var code : Number,
                  var message: String,
                  var details : MutableList<Extension> = mutableListOf())

data class Extension(var type : String) : HashMap<String, Any>(hashMapOf("@type" to type))

data class DateTime(var date : Date,
                    var time : TimeOfDay)

data class Date(var year : Number,
                var month: Number,
                var day : Number)

data class TimeOfDay(var hours: Number,
                     var minutes: Number,
                     var seconds: Number,
                     var nanos: Number)