package au.com.louth.kwiet.dialogflow.model

data class Request(var responseId : String? = null,
                   var session : String? = null,
                   var queryResult: QueryResult? = null,
                   var originalDetectIntentRequest: OriginalDetectIntentRequest? = null)


data class QueryResult(var queryText: String? = null,
                       var languageCode: String? = null,
                       var speechRecognitionConfidence : Number? = null,
                       var action: String? = null,
                       var parameters: MutableMap<String, Any>?= null,
                       var allRequiredParamsPresent: Boolean = true,
                       var fulfillmentText: String? = null,
                       var fulfillmentMessages : MutableList<Message> = mutableListOf(),
                       var webhookSource : String? = null,
                       var webhookPayload : MutableMap<String,Any>? = null,
                       var outputContexts : MutableList<Context> = mutableListOf(),
                       var intent : Intent? = null,
                       var intentDetectionConfidence : Number? = null,
                       var diagnosticInfo : MutableMap<String,Any>? = null)


class OriginalDetectIntentRequest(var source : String? = null,
                                  var payload : MutableMap<String,Any>? = null)

class Message(var platform : Platform? = null,
              var text : MutableList<String> = mutableListOf(),
              var image: Image? = null,
              var quickReplies: QuickReplies? = null,
              var card: Card? = null,
              var payload: MutableMap<String, Any>? = null,
              var simpleResponses: MutableList<SimpleResponse> = mutableListOf(),
              var basicCard: BasicCard? = null,
              var suggestions: MutableList<Suggestion> = mutableListOf(),
              var linkOutSuggestion: LinkOutSuggestion? = null,
              var listSelect: ListSelect? = null,
              var carouselSelect: CarouselSelect? = null)

data class Context(var name: String? = null, var lifespanCount : Number? = null, var parameters: MutableMap<String, Any>? = null)

class Intent(var name: String? = null,
             var displayName: String? = null,
             var webhookState: WebhookState? = null,
             var priority: Number? = null,
             var isFallback: Boolean = false,
             var mlDisabled: Boolean = false,
             var inputContextNames: MutableList<String> = mutableListOf(),
             var events: MutableList<String> = mutableListOf(),
             var trainingPhases: MutableList<TrainingPhase> = mutableListOf(),
             var action: String? = null,
             var outputContexts: MutableList<Context> = mutableListOf(),
             var resetContexts: Boolean = false,
             var parameters: MutableList<Parameter> = mutableListOf(),
             var messages: MutableList<Message> = mutableListOf(),
             var defaultResponsePlatforms: MutableList<Platform> = mutableListOf(),
             var rootFollowupIntentName: String? = null,
             var parentFollowupIntentName : String? = null,
             var followupIntentInfo: MutableList<FollowupIntentInfo> = mutableListOf())

enum class Platform { PLATFORM_UNSPECIFIED, FACEBOOK, SLACK, TELEGRAM, KIK, SKYPE, LINE, VIBER, ACTIONS_ON_GOOGLE }

class Image(var imageUri: String? = null, accesibilityText : String? = null)

class QuickReplies()

class Card()

class SimpleResponse()

class BasicCard()

class Suggestion()

class LinkOutSuggestion()

class ListSelect()

class CarouselSelect()

class WebhookState()

class TrainingPhase()

class Parameter()

class FollowupIntentInfo()