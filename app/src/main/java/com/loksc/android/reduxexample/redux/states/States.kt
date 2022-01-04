package com.loksc.android.reduxexample.redux.states

data class GlobalState (
    var appState: AppState = AppState(),
    var testState: TestState = TestState(),
)

data class AppState (
    var user: String? = null,
)

data class TestState(
    val message: String? = null,
)
