package com.example.d4w2_coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val deferred = GlobalScope.async {
        // some business logic
        throw UnsupportedOperationException()
    }
    try {
        deferred.await() // The exception is thrown here
        println("Won't be printed")
    } catch (e: UnsupportedOperationException) {
        println("UnsupportedOperationException handled !")
    }
}