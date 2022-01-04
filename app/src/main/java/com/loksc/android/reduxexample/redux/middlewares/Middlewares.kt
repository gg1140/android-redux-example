package com.loksc.android.reduxexample.redux.middlewares

import com.loksc.android.reduxexample.redux.actions.*
import com.loksc.android.reduxexample.redux.states.*
import kotlinx.coroutines.*
import org.reduxkotlin.Middleware

fun createMiddleware(logic: (action: Action) -> Unit): Middleware<GlobalState> {
    return { store -> { next -> { action ->
        if (action is Action) logic(action)
        next(action)
    }}}
}

val loggerMiddleware: Middleware<GlobalState> = createMiddleware { action ->
    println("reduxLogger::DISPATCHED => \"${action.group}/${action.action}\"")
}

val epicTester: Middleware<GlobalState> =  createMiddleware {
    CoroutineScope(Dispatchers.IO).launch {
        delay(5000)
        println("epicTester::task completed")
    }
}
