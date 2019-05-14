package com.kuzheevadel.daggerviewmodule

import android.content.Context
import android.util.Log

class Database(private val context: Context) {
    var index = 0

    fun settIndex(i: Int) {
        index = i
    }

    fun load() {
        Log.i("ViewModelTest", "Database.load $context")
    }

    fun self() {
        Log.i("ViewModelTest", "Database.self $this : $index")

    }
}

class Network() {
    fun connect() {
        Log.i("ViewModelTest", "Network.load")
    }
}