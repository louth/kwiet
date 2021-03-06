package au.com.louth.kwiet.actionssdk.model

data class Price(var type: PriceType,
                 var amount: Money)

data class Money(var currencyCode : String,
                 var units: String,
                 var nanos : Number)