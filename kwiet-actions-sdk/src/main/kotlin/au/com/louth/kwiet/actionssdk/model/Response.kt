package au.com.louth.kwiet.actionssdk.model


data class AppResponse(var conversationToken : String? = null,
                       var userStorage : String? = null,
                       var resetUserStorage : Boolean?  = null,
                       var expectUserResponse : Boolean = true,
                       var expectedInputs : MutableList<ExpectedInput> = mutableListOf(),
                       var finalResponse: FinalResponse? = null,
                       var customPushMessage: CustomPushMessage? = null,
                       var isInSandbox : Boolean? = null
)

data class ExpectedInput(var inputPrompt: InputPrompt? = null,
                         var possibleIntents: MutableList<ExpectedIntent> = mutableListOf(),
                         var speechBiasHints: MutableList<String>? = null)

data class InputPrompt(var richInitialPrompt : RichResponse? = null,
                       var noInputPrompts : MutableList<SimpleResponse>? = null)

data class RichResponse(var items: MutableList<Item> = mutableListOf(),
                        var suggestions: MutableList<Suggestion>? = null,
                        var linkOutSuggestion: LinkOutSuggestion? = null)

data class Item(var simpleResponse: SimpleResponse? = null,
                var basicCard: BasicCard? = null,
                var structuredResponse: StructuredResponse? = null,
                var mediaResponse : MediaResponse? = null,
                var carouselBrowse : CarouselBrowse? = null)

data class SimpleResponse(var textToSpeech : String? = null,
                          var ssml : String? = null,
                          var displayText : String? = null)


data class BasicCard(var title: String,
                     var subtitle : String,
                     var formattedText : String,
                     var image: Image,
                     var buttons: MutableList<Button>? = null,
                     var imageDisplayOptions : ImageDisplayOptions)

data class Button(var title: String,
                  var openUrlAction: OpenUrlAction)

data class StructuredResponse(var orderUpdate : OrderUpdate)

data class OrderUpdate(var googleOrderId : String,
                       var actionOrderId : String,
                       var orderState : OrderState,
                       var orderManagementActions : MutableList<Action>? = null,
                       var receipt : Receipt,
                       var updateTime: String,
                       var totalPrice: Price,
                       var lineItemUpdates: LineItemUpdate,
                       var userNotification : UserNotification,
                       var infoExtension: Extension,
                       var rejectionInfo : RejectionInfo? = null,
                       var cancellationInfo : CancellationInfo? = null,
                       var inTransitInfo : InTransitInfo? = null,
                       var fulfillmentInfo : FulfillmentInfo? = null,
                       var returnInfo: ReturnInfo? = null)

data class Action(var type: ActionType,
                  var button: Button)

data class Receipt(@Deprecated("deprecated") var confirmedActionOrderId : String,
                   var userVisibleOrderId : String)

data class RejectionInfo(var type: ReasonType,
                         var reason: String)

data class CancellationInfo(var reason: String)
data class InTransitInfo(var updatedTime: String)
data class FulfillmentInfo(var deliveryTime: String)
data class ReturnInfo(var reason: String)

data class UserNotification(var title : String,
                            var text: String)

data class MediaResponse (var mediaType : MediaType = MediaType.MEDIA_TYPE_UNSPECIFIED,
                          var mediaObjects: MutableList<MediaObject>? = null)

data class MediaObject(var name : String,
                       var description: String,
                       var contentUrl: String,
                       var largeImage: Image? = null,
                       var icon: Image? = null)

data class CarouselBrowse(var items: MutableList<CarouselItem>? = null,
                          var imageDisplayOptions: ImageDisplayOptions)

data class CarouselItem(var title: String,
                        var description: String,
                        var footer : String,
                        var image : Image,
                        var openUrlAction: OpenUrlAction)

data class Suggestion(var title: String)

data class LinkOutSuggestion(var destinationName : String,
                             var url : String,
                             var openUrlAction: OpenUrlAction)

data class ExpectedIntent(var intent : String? = null,
                          var inputValueData : Extension? = null,
                          var parameterName : String? = null)

data class FinalResponse(var richResponse : RichResponse? = null)

data class CustomPushMessage(var target: Target)

data class Target(var userId: String,
                  var intent: String,
                  var argument : Argument,
                  var locale: String)