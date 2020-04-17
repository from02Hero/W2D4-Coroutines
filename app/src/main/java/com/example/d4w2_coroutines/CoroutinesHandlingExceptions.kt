package com.example.d4w2_coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("$exception handled !")
    }
    val job = GlobalScope.launch(handler) {
        throw UnsupportedOperationException()
    }
    job.join()
}