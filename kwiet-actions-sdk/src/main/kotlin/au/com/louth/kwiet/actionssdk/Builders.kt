package au.com.louth.kwiet.actionssdk

import au.com.louth.kwiet.actionssdk.StandardIntent.TEXT
import au.com.louth.kwiet.actionssdk.models.*

fun response(init: AppResponse.() -> Unit) {
    val response = AppResponse()
    response.init()
}

fun AppResponse.expectedInput(init: ExpectedInput.() -> Unit) {
    val expectedInput = ExpectedInput()
    expectedInput.init()
    expectedInputs.add(expectedInput)
}

fun AppResponse.finalResponse(init: FinalResponse.() -> Unit) {
    val finalResponse = FinalResponse()
    finalResponse.init()
    this.finalResponse = finalResponse
}

fun ExpectedInput.inputPrompt(init: InputPrompt.() -> Unit) {
    val inputPrompt = InputPrompt()
    inputPrompt.init()
    this.inputPrompt = inputPrompt
}

fun InputPrompt.richResponse(init: RichResponse.() -> Unit) {
    val richResponse = RichResponse()
    richResponse.init()
    richInitialPrompt = richResponse
}

fun FinalResponse.richResponse(init: RichResponse.() -> Unit) {
    val richResponse = RichResponse()
    richResponse.init()
    this.richResponse = richResponse
}

fun RichResponse.item(init: Item.() -> Unit) {
    val item = Item()
    item.init()
    items.add(item)
}

fun Item.simpleResponse(init: SimpleResponse.() -> Unit) {
    val simpleResponse = SimpleResponse()
    simpleResponse.init()
    this.simpleResponse = simpleResponse
}

fun ExpectedInput.possibleIntents(init: MutableList<ExpectedIntent>.() -> Unit) {
    val possibleIntents = mutableListOf<ExpectedIntent>()
    possibleIntents.init()
    this.possibleIntents = possibleIntents
}

fun MutableList<ExpectedIntent>.intent(init: ExpectedIntent.() -> Unit) {
    val expectedIntent = ExpectedIntent()
    expectedIntent.init()
    add(expectedIntent)
}

fun simpleResponse(init: SimpleResponse.() -> Unit): AppResponse {

    val response = AppResponse()

    response.expectedInput {
        inputPrompt {
            richResponse {
                item {
                    simpleResponse {
                        init()
                    }
                }
            }
        }
        possibleIntents {
            intent {
                intent = TEXT
            }
        }
    }

    return response
}

fun finalResponse(init: SimpleResponse.() -> Unit) : AppResponse {

    val response = AppResponse()

    response.expectUserResponse = false
    response.finalResponse {
        richResponse {
            item {
                simpleResponse {
                    init()
                }
            }
        }
    }

    return response
}

fun AppResponse.possibleIntents(vararg intents : String) : AppResponse {
    expectedInputs.forEach { input ->
        input.possibleIntents.clear()
        intents.forEach {
            input.possibleIntents.add(ExpectedIntent(it))
        }
    }
    return this
}



