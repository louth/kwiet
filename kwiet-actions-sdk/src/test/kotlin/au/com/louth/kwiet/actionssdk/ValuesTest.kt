package au.com.louth.kwiet.actionssdk

import au.com.louth.kwiet.actionssdk.StandardIntent.MAIN
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class ValuesTest() {

    @Test
    fun verifyStandardIntents() {
        assertThat(MAIN, `is`("actions.intent.MAIN"))
    }

}