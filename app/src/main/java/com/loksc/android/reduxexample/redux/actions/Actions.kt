package com.loksc.android.reduxexample.redux.actions

import com.loksc.android.reduxexample.redux.ReduxGroups

/**
 * Use abstract Class to map ReduxGroups to Actions
 */

abstract class Action(
    val group: String,
    val action: String,
)

abstract class TestAction(
    action: String,
): Action (ReduxGroups.TEST, action)

data class SaveMessageAction(val message: String): TestAction("TESTER_ACTION")
