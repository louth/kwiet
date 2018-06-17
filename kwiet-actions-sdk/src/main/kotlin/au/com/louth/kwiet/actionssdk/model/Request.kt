package au.com.louth.kwiet.actionssdk.model

data class AppRequest(var user: User? = null,
                      var device: Device? = null,
                      var surface: Surface? = null,
                      var conversation: Conversation? = null,
                      var inputs: MutableList<Input> = mutableListOf(),
                      var isInSandbox : Boolean? = null,
                      var availableSurfaces : MutableList<Surface> = mutableListOf()) {

    fun intents() : Set<String?> = inputs.map { it.intent }.toSet()

    fun getText() = getArg("text")

    private fun getArg(name: String) : String {
        var value : String = ""

        inputs.forEach {
            input -> input.arguments.forEach {
                arg -> if (arg.name == name) {
                    value = arg.textValue ?: value
                }
            }
        }

        return value
    }
}

data class User(var userId : String? = null,
                var profile : UserProfile? = null,
                var accessToken : String? = null,
                var permissions : MutableList<Permission> = mutableListOf(),
                var locale : String? = null,
                var lastSeen : String? = null,
                var userStorage: String? = null,
                var packageEntitlements: MutableList<PackageEntitlement> = mutableListOf())

data class UserProfile(var displayName : String? = null,
                       var givenName : String? = null,
                       var familyName : String? = null)

data class PackageEntitlement(var packageName : String? = null,
                              var entitlements : MutableList<Entitlement> = mutableListOf())

data class Entitlement(var sku : String? = null,
                       var skuType: SkuType? = null,
                       var inAppDetails: SignedData? = null)

data class SignedData(var inAppPurchaseData : MutableMap<String, Any> = mutableMapOf(),
                      var inAppDataSignature : String? = null)

data class Device(var location: Location? = null)

data class Surface(var capabilities: MutableList<Capability> = mutableListOf())

data class Capability(var name: String? = null)

data class Conversation(var conversationId: String? = null,
                        var type: ConversationType? = null,
                        var conversationToken: String? = null)

data class Input(var rawInputs: MutableList<RawInput> = mutableListOf(),
                 var intent: String? = null,
                 var arguments: MutableList<Argument> = mutableListOf())

data class RawInput(var inputType: InputType? = null,
                    var query: String? = null)
