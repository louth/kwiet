package au.com.louth.kwiet.actionssdk.model

enum class ActionType {
    UNKNOWN,    //Unknown action.
    VIEW_DETAILS,    //View order details action on merchant side.
    MODIFY,    //Modify order action.
    CANCEL,    //Cancel order action.
    RETURN,    //Return order action.
    EXCHANGE,    //Exchange order action.
    EMAIL,    //Email action.
    CALL,    //Call action.
    REORDER,    //Reorder action.
    REVIEW,    //Review order action.
    CUSTOMER_SERVICE    //Contact customer service.
}

enum class ConversationType {
    TYPE_UNSPECIFIED,
    NEW,
    ACTIVE
}

data class Image(var url: String,
                 var accessibilityText: String,
                 var height: Number,
                 var width: Number)

enum class ImageDisplayOptions {
    DEFAULT,	// Fill the gaps between the image and the image container with gray bars.
    WHITE,	    // Fill the gaps between the image and the image container with white bars.
    CROPPED     // Image is scaled such that the image width and height match or exceed the container dimensions.
                // This may crop the top and bottom of the image if the scaled image height is greater than the container height,
                // or crop the left and right of the image if the scaled image width is greater than the container width.
                // This is similar to "Zoom Mode" on a widescreen TV when playing a 4:3 video.
}

enum class InputType {
    UNSPECIFIED_INPUT_TYPE,
    TOUCH,
    VOICE,
    KEYBOARD
}

data class LineItemUpdate(var orderState: OrderState,
                          var price: Price,
                          var reason: String,
                          var extension: Extension)

enum class MediaType {
    MEDIA_TYPE_UNSPECIFIED,
    AUDIO
}

data class OrderState(var state: String,
                      var label: String)

enum class Permission {
    UNSPECIFIED_PERMISSION,
    NAME,                       // Ask for user's first and last name.
    DEVICE_PRECISE_LOCATION,    // Ask for user's precise location, lat/lng and formatted address. Returns only lat/lng on phones.
    DEVICE_COARSE_LOCATION,        // Ask for user's coarse location, zip code, city and country code. Works only from Google Home devices.
    UPDATE                        // Ask for permissions to send updates.
}

enum class PriceType {
    UNKNOWN,
    ESTIMATE,
    ACTUAL
}

enum class ReasonType {
    UNKNOWN,
    PAYMENT_DECLINED,
    INELIGIBLE,    //User ineligible to place order (blacklisted).
    PROMO_NOT_APPLICABLE,
    UNAVAILABLE_SLOT,    // Order ahead slot is unavailable.
}

enum class SkuType {
    TYPE_UNSPECIFIED,
    IN_APP,
    SUBSCRIPTION,
    APP
}

enum class UrlTypeHint {
    URL_TYPE_HINT_UNSPECIFIED,    //Unspecified
    AMP_CONTENT
}