package com.loksc.android.reduxexample.redux.reducers

import com.loksc.android.reduxexample.redux.actions.*
import com.loksc.android.reduxexample.redux.states.*
import org.reduxkotlin.Reducer

/* Mapping ReduxGroups to Reducers */
val globalReducer: Reducer<GlobalState> = { state, action ->
    when (action) {
        is TestAction -> state.copy(testState = testReducer(state.testState, action))
        else -> state
    }
}

val appReducer: Reducer<AppState> = { state, action ->
    when (action) {
        else -> state
    }
}

val testReducer: Reducer<TestState> = { state, action ->
    when (action) {
        is SaveMessageAction -> state.copy(message = action.message)
        else -> state
    }
}
