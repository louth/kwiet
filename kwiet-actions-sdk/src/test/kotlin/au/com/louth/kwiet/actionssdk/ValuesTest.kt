package au.com.louth.kwiet.actionssdk

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class ValuesTest() {

    @Test
    fun verifyStandardIntents() {
        assertThat(StandardIntent.MAIN, `is`("actions.intent.MAIN"))
        assertThat(StandardIntent.TEXT, `is`("actions.intent.TEXT"))
        assertThat(StandardIntent.PERMISSION, `is`("actions.intent.PERMISSION"))
        assertThat(StandardIntent.OPTION, `is`("actions.intent.OPTION"))
        assertThat(StandardIntent.TRANSACTION_REQUIREMENTS_CHECK, `is`("actions.intent.TRANSACTION_REQUIREMENTS_CHECK"))
        assertThat(StandardIntent.DELIVERY_ADDRESS, `is`("actions.intent.DELIVERY_ADDRESS"))
        assertThat(StandardIntent.TRANSACTION_DECISION, `is`("actions.intent.TRANSACTION_DECISION"))
        assertThat(StandardIntent.CONFIRMATION, `is`("actions.intent.CONFIRMATION"))
        assertThat(StandardIntent.DATETIME, `is`("actions.intent.DATETIME"))
        assertThat(StandardIntent.SIGN_IN, `is`("actions.intent.SIGN_IN"))
        assertThat(StandardIntent.NO_INPUT, `is`("actions.intent.NO_INPUT"))
        assertThat(StandardIntent.CANCEL, `is`("actions.intent.CANCEL"))
        assertThat(StandardIntent.NEW_SURFACE, `is`("actions.intent.NEW_SURFACE"))
        assertThat(StandardIntent.REGISTER_UPDATE, `is`("actions.intent.REGISTER_UPDATE"))
        assertThat(StandardIntent.CONFIGURE_UPDATES, `is`("actions.intent.CONFIGURE_UPDATES"))
    }

    @Test
    fun verifyStandardArguments() {
        assertThat(StandardArgument.PERMISSION_GRANTED,`is`("PERMISSION"))
        assertThat(StandardArgument.OPTION,`is`("OPTION"))
        assertThat(StandardArgument.TRANSACTION_REQ_CHECK_RESULT,`is`("TRANSACTION_REQUIREMENTS_CHECK_RESULT"))
        assertThat(StandardArgument.DELIVERY_ADDRESS_VALUE,`is`("DELIVERY_ADDRESS_VALUE"))
        assertThat(StandardArgument.TRANSACTION_DECISION_VALUE,`is`("TRANSACTION_DECISION_VALUE"))
        assertThat(StandardArgument.CONFIRMATION,`is`("CONFIRMATION"))
        assertThat(StandardArgument.DATETIME,`is`("DATETIME"))
        assertThat(StandardArgument.SIGN_IN,`is`("SIGN_IN"))
        assertThat(StandardArgument.REPROMPT_COUNT,`is`("REPROMPT_COUNT"))
        assertThat(StandardArgument.IS_FINAL_REPROMPT,`is`("IS_FINAL_REPROMPT"))
        assertThat(StandardArgument.NEW_SURFACE,`is`("NEW_SURFACE"))
        assertThat(StandardArgument.REGISTER_UPDATE,`is`("REGISTER_UPDATE"))
    }

}