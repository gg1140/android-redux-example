package com.loksc.android.reduxexample.redux

import com.loksc.android.reduxexample.redux.middlewares.*
import com.loksc.android.reduxexample.redux.reducers.*
import com.loksc.android.reduxexample.redux.states.*
import org.reduxkotlin.Store
import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createThreadSafeStore

object Redux {
    val store: Store<GlobalState> = createThreadSafeStore(
        globalReducer,
        GlobalState(),
        applyMiddleware(
            loggerMiddleware,
            epicTester,
        )
    )
}

// TODO: use Sealed Class
/* All actions, states, & reducers shall be categorised by these labels */
class ReduxGroups {
    companion object {
        const val General = "GENERAL"
        const val TEST = "TEST"
        const val PrintDn = "PRINT_DN"
    }
}

fun Store<GlobalState>.subscribe(group: String, subscriber: (Any) -> Unit) {
    this.subscribe {
        val state = this.selectStateByGroup(group)
        subscriber(state)
    }
}

/* Mapping ReduxGroups to State */
fun Store<GlobalState>.selectStateByGroup(group: String): Any {
    return when (group) {
        ReduxGroups.General -> this.state.appState
        ReduxGroups.TEST -> this.state.testState
        else -> this.state
    }
}
