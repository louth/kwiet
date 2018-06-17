package au.com.louth.kwiet.actionssdk

import au.com.louth.kwiet.actionssdk.model.AppRequest
import au.com.louth.kwiet.actionssdk.model.AppResponse
import kotlin.reflect.KFunction


fun handleLambdaRequest(request: AppRequest, context: Any, handlers: Map<String, KFunction<*>>) : AppResponse {

    val intent = request.intents().first { handlers.containsKey(it) }

    val function = handlers[intent]

    return (when(function?.parameters?.size) {
        2 -> function.call(request, context)
        1 -> function.call(request)
        else -> function?.call()
    }) as AppResponse

}

