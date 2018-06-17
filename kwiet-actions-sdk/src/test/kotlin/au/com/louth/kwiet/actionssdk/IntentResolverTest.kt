package au.com.louth.kwiet.actionssdk

import au.com.louth.kwiet.actionssdk.StandardIntent.CANCEL
import au.com.louth.kwiet.actionssdk.StandardIntent.MAIN
import au.com.louth.kwiet.actionssdk.StandardIntent.TEXT
import au.com.louth.kwiet.actionssdk.model.AppRequest
import au.com.louth.kwiet.actionssdk.model.Input
import org.junit.Test
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat

class IntentResolverTest {

    fun functionZero() = simpleResponse { textToSpeech = "zero parameters" }
    fun functionOne(param1 : Any) = simpleResponse { textToSpeech = "one parameter" }
    fun functionTwo(param1 : Any, param2 : Any) = simpleResponse { textToSpeech = "two parameters" }

    val handlers = mapOf(CANCEL to ::functionZero, TEXT to ::functionOne, MAIN  to ::functionTwo)

    @Test
    fun verifyFunctionWithNoParametersCalled() {
        val request = AppRequest(inputs = mutableListOf(Input(intent = CANCEL)))

        val response = handleLambdaRequest(request, "", handlers)
        assertThat(response, `is`(simpleResponse { textToSpeech = "zero parameters" }))
    }

    @Test
    fun verifyFunctionWithOneParametersCalled() {
        val request = AppRequest(inputs = mutableListOf(Input(intent = TEXT)))

        val response = handleLambdaRequest(request, "", handlers)
        assertThat(response, `is`(simpleResponse { textToSpeech = "one parameter" }))
    }

    @Test
    fun verifyFunctionWithTwoParametersCalled() {
        val request = AppRequest(inputs = mutableListOf(Input(intent = MAIN)))

        val response = handleLambdaRequest(request, "", handlers)
        assertThat(response, `is`(simpleResponse { textToSpeech = "two parameters" }))
    }

}