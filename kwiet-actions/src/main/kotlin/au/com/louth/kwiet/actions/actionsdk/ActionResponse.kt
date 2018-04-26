package au.com.louth.kwiet.actions.actionsdk

import au.com.louth.kwiet.actions.GoogleData
import au.com.louth.kwiet.actions.RichResponse
import au.com.louth.kwiet.actions.SimpleResponse


data class ActionResponse(var conversationToken: String? = null,
                          var expectUserResponse: Boolean = true,
                          var expectedInputs: MutableList<ExpectedInput>? = null,
                          var finalResponse: FinalResponse? = null) {

}


data class InputPrompt(
        var initialPrompts: MutableList<GoogleData.NoInputPrompts>? = null,
        var noInputPrompts: MutableList<GoogleData.NoInputPrompts>? = null,
        var richInitialPrompt: RichResponse? = null)



data class FinalResponse(var richResponse: RichResponse? = null,
                         var speechResponse: SimpleResponse? = null)


