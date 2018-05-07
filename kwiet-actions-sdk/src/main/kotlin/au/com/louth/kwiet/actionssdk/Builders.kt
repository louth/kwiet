package au.com.louth.kwiet.actionssdk

import au.com.louth.kwiet.actionssdk.StandardIntent.TEXT
import au.com.louth.kwiet.actionssdk.models.*

fun appResponse(init: AppResponse.() -> Unit)  : AppResponse {
    val response = AppResponse()
    response.init()
    return response
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

fun AppResponse.possibleIntents(vararg intents: String): AppResponse {
    if (expectedInputs.size == 0) {
        expectedInputs.add(ExpectedInput())
    }
    expectedInputs.forEach { input ->
        input.possibleIntents.clear()
        intents.forEach {
            input.possibleIntents.add(ExpectedIntent(it))
        }
    }
    return this
}

fun ExpectedInput.inputPrompt(init: InputPrompt.() -> Unit) {
    val inputPrompt = InputPrompt()
    inputPrompt.init()
    this.inputPrompt = inputPrompt
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

fun simpleResponse(init: SimpleResponse.() -> Unit): AppResponse {

    val response = appResponse {
        expectedInput {
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
    }

    return response
}

fun finalResponse(init: SimpleResponse.() -> Unit): AppResponse {

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

//    return appResponse {
//        expectUserResponse = false
//        expectedInput {
//            finalResponse {
//                richResponse {
//                    item {
//                        simpleResponse {
//                            init()
//                        }
//                    }
//                }
//            }
//        }
//    }
}



