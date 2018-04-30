package au.com.louth.kwiet.actionssdk

import au.com.louth.kwiet.actionssdk.models.AppRequest
import au.com.louth.kwiet.actionssdk.models.AppResponse

fun handleRequest(handlers: Map<String, (AppRequest) -> AppResponse>, request: AppRequest) : AppResponse {
    val intent = request.intents().first {
        handlers.containsKey(it)
    }
    return handlers.get(intent)?.invoke(request) ?: AppResponse(conversationToken = "FAIL")
}

