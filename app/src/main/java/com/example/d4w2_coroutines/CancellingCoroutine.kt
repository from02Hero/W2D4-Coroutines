package com.example.d4w2_coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        // Emulate some batch processing
        repeat(30) { i ->
            println("Processing $i ...")
            delay(300L)
        }
    }
    delay(1000L)
    println("main: The user requests the cancellation of the processing")
    job.cancelAndJoin() // cancel the job and wait for it's completion
    println("main: The batch processing is cancelled")
}