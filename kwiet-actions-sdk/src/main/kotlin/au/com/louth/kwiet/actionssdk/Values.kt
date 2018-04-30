package au.com.louth.kwiet.actionssdk

object StandardIntent {
    /** App fires MAIN intent for queries like [talk to $app]. */
    val MAIN = "actions.intent.MAIN"

    /** App fires TEXT intent when action issues ask intent. */
    val TEXT = "actions.intent.TEXT"

    /** App fires PERMISSION intent when action invokes askForPermission. */
    val PERMISSION = "actions.intent.PERMISSION"

    /** App fires OPTION intent when user chooses from options provided. */
    val OPTION = "actions.intent.OPTION"

    /** App fires TRANSACTION_REQUIREMENTS_CHECK intent when action sets up transaction. */
    val TRANSACTION_REQUIREMENTS_CHECK = "actions.intent.TRANSACTION_REQUIREMENTS_CHECK"

    /** App fires DELIVERY_ADDRESS intent when action asks for delivery address. */
    val DELIVERY_ADDRESS = "actions.intent.DELIVERY_ADDRESS"

    /** App fires TRANSACTION_DECISION intent when action asks for transaction decision. */
    val TRANSACTION_DECISION = "actions.intent.TRANSACTION_DECISION"

    /** App fires CONFIRMATION intent when requesting affirmation from user. */
    val CONFIRMATION = "actions.intent.CONFIRMATION"

    /** App fires DATETIME intent when requesting date/time from user. */
    val DATETIME = "actions.intent.DATETIME"

    /** App fires SIGN_IN intent when requesting sign-in from user. */
    val SIGN_IN = "actions.intent.SIGN_IN"

    /** App fires NO_INPUT intent when user doesn't provide input. */
    val NO_INPUT = "actions.intent.NO_INPUT"

    /** App fires CANCEL intent when user exits app mid-dialog. */
    val CANCEL = "actions.intent.CANCEL"

    /** App fires NEW_SURFACE intent when requesting handoff to a new surface from user. */
    val NEW_SURFACE = "actions.intent.NEW_SURFACE"

    /** App fires REGISTER_UPDATE intent when requesting the user to register for proactive updates. */
    val REGISTER_UPDATE = "actions.intent.REGISTER_UPDATE"

    /** App receives CONFIGURE_UPDATES intent to indicate a custom REGISTER_UPDATE intent should be sent. */
    val CONFIGURE_UPDATES = "actions.intent.CONFIGURE_UPDATES"
}

object StandardArgument {
    /** Permission granted argument. */
    val PERMISSION_GRANTED = "PERMISSION"

    /** Option selected argument. */
    val OPTION = "OPTION"

    /** Transaction requirements check result argument. */
    val TRANSACTION_REQ_CHECK_RESULT = "TRANSACTION_REQUIREMENTS_CHECK_RESULT"

    /** Delivery address value argument. */

    val DELIVERY_ADDRESS_VALUE = "DELIVERY_ADDRESS_VALUE"

    /** Transactions decision argument. */
    val TRANSACTION_DECISION_VALUE = "TRANSACTION_DECISION_VALUE"

    /** Confirmation argument. */
    val CONFIRMATION = "CONFIRMATION"

    /** DateTime argument. */
    val DATETIME = "DATETIME"

    /** Sign in status argument. */
    val SIGN_IN = "SIGN_IN"

    /** Reprompt count for consecutive NO_INPUT intents. */
    val REPROMPT_COUNT = "REPROMPT_COUNT"

    /** Flag representing finality of NO_INPUT intent. */
    val IS_FINAL_REPROMPT = "IS_FINAL_REPROMPT"

    /** New surface value argument. */
    val NEW_SURFACE = "NEW_SURFACE"

    /** Update registration value argument. */
    val REGISTER_UPDATE = "REGISTER_UPDATE"
}