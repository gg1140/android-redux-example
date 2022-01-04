package com.loksc.android.reduxexample

import android.app.Application
import com.loksc.android.reduxexample.redux.Redux

class ReduxExampleApp: Application() {
    val store = Redux.store
}