package au.com.louth.kwiet.actionssdk

import au.com.louth.kwiet.actionssdk.StandardIntent.CANCEL
import au.com.louth.kwiet.actionssdk.StandardIntent.MAIN
import au.com.louth.kwiet.actionssdk.StandardIntent.TEXT
import au.com.louth.kwiet.actionssdk.models.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class BuildersTest() {

    val mapper = jacksonObjectMapper().writerWithDefaultPrettyPrinter()

    @Test
    fun verifyAppResponseDSL() {
        val actual = appResponse { }
        val expected = AppResponse()
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyExpectedInputInAppResponseDSL() {
        val actual = appResponse { expectedInput {  } }
        val expected = AppResponse(expectedInputs = mutableListOf(ExpectedInput()))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyFinalResponseInAppResponseDSL() {
        val actual = appResponse { finalResponse {  } }
        val expected = AppResponse(finalResponse = FinalResponse())
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyPossibleIntentsInAppResponseDSL() {
        val actual = appResponse { expectedInput {  } }.possibleIntents(MAIN, CANCEL, TEXT)
        val expected = AppResponse(expectedInputs = mutableListOf(ExpectedInput(possibleIntents = mutableListOf(ExpectedIntent(MAIN), ExpectedIntent(CANCEL), ExpectedIntent(TEXT)))))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyPossibleIntentsInAppResponseWithNoExpectedInputsDSL() {
        val actual = appResponse {  }.possibleIntents(MAIN, CANCEL, TEXT)
        val expected = AppResponse(expectedInputs = mutableListOf(ExpectedInput(possibleIntents = mutableListOf(ExpectedIntent(MAIN), ExpectedIntent(CANCEL), ExpectedIntent(TEXT)))))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyInputPromptInExpectedInputDSL() {
        val actual = appResponse { expectedInput { inputPrompt {  } } }
        val expected = AppResponse(expectedInputs = mutableListOf(ExpectedInput(inputPrompt = InputPrompt())))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyPossibleIntentsInExpectedInputDSL() {
        val actual = appResponse { expectedInput { possibleIntents { intent {  } } } }
        val expected = AppResponse(expectedInputs = mutableListOf(ExpectedInput(possibleIntents = mutableListOf(ExpectedIntent()))))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyRichResponseInInputPromptDSL() {
        val actual = appResponse { expectedInput { inputPrompt { richResponse {  } } } }
        val expected = AppResponse(expectedInputs = mutableListOf(ExpectedInput(inputPrompt = InputPrompt(richInitialPrompt = RichResponse()))))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyRichResponseInFinalRespnseDSL() {
        val actual = appResponse { finalResponse { richResponse {  } } }
        val expected = AppResponse(finalResponse = FinalResponse(richResponse = RichResponse()))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyItemInRichResponseDSL() {
        val actual = appResponse { finalResponse { richResponse { item { } } } }
        val expected = AppResponse(finalResponse = FinalResponse(richResponse = RichResponse(items = mutableListOf(Item()))))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifySimpleResponseInItemDSL() {
        val actual = appResponse { finalResponse { richResponse { item { simpleResponse { textToSpeech = "Wabbadubbadubdub" } } } } }
        val expected = AppResponse(finalResponse = FinalResponse(richResponse = RichResponse(items = mutableListOf(Item(simpleResponse = SimpleResponse("Wabbadubbadubdub"))))))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifySimpleResponseDSL() {
        val actual = simpleResponse {
            textToSpeech = "this is textToSpeech"
            displayText = "this is displayText"
        }
        val expected = AppResponse(
                expectedInputs = mutableListOf(ExpectedInput(InputPrompt(RichResponse(mutableListOf(Item(
                        SimpleResponse(textToSpeech = "this is textToSpeech", displayText = "this is displayText"))))),
                        mutableListOf(ExpectedIntent(TEXT)))))

        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

    @Test
    fun verifyFinalResponseDSL() {
        val actual = finalResponse { textToSpeech = "the final countdown" }
        val expected = AppResponse(expectUserResponse = false, finalResponse = FinalResponse(RichResponse(mutableListOf(Item(SimpleResponse(textToSpeech = "the final countdown"))))))
        println(mapper.writeValueAsString(actual))
        assertThat(actual, `is`(expected))
    }

}