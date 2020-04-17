package com.example.d4w2_coroutines

import kotlinx.coroutines.*

//fun main() = runBlocking {
//    withTimeout(1000L) {
//        repeat(30) { i ->
//            println("Processing $i ...")
//            delay(300L)
//        }
//    }
//}

// avoid exception
fun main() = runBlocking {
    val status = withTimeoutOrNull(1000L) {
        repeat(30) { i ->
            println("Processing $i ...")
            delay(300L)
        }
        "Finished"
    }
    println("The processing return status is: $status")
}