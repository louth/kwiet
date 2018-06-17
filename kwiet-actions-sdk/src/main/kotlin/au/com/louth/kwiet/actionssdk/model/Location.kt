package au.com.louth.kwiet.actionssdk.model

data class Location(
        var coordinates: LatLng,
        var formattedAddress : String,
        var zipCode : String,
        var city : String,
        var postalAddress: PostalAddress,
        var name : String,
        var phoneNumber : String,
        var notes: String)

data class LatLng (
        var latitude : Number,
        var longitude : Number)

data class PostalAddress(
        var revision: Number,
        var regionCode: String,
        var languageCode: String,
        var postalCode: String,
        var sortingCode: String,
        var administrativeArea: String,
        var locality: String,
        var sublocality: String,
        var addressLines: MutableList<String> = mutableListOf(),
        var recipients: MutableList<String> = mutableListOf(),
        var organization: String)