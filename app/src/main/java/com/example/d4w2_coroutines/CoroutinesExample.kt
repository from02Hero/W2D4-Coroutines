package com.example.d4w2_coroutines

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.*
import java.time.LocalDateTime

val uiScope = CoroutineScope(Dispatchers.Main)

fun main() {
    println("The main program is started")
    GlobalScope.launch {
        println("Background processing started")
        delay(500L)
        println("Background processing finished")
    }
    println("The main program continues")
    runBlocking {
        delay(1000L)
        println("The main program is finished")
    }
}

fun mainAndWorkerThreadWorkingTogether() {
    println("The main program is started")
    GlobalScope.launch {
        println("Background processing started")
        delay(500L)
        println("Background processing finished")
    }
    println("The main program continues")
    // We need this part because we are running a method and we want to let the worker thread finish its execution
    runBlocking {
        delay(1000L)
        println("The main program is finished")
    }
}