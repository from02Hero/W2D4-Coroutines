package com.example.d4w2_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val coroutineScope =
        CoroutineScope(Dispatchers.Main)

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDoAsync.setOnClickListener {
            coroutineScope.launch(Dispatchers.Main) {
                loadData(10)
            }
        }

        submit.setOnClickListener {
            counter++
            textView.text = counter.toString()
        }
    }

    suspend fun loadData(params: Int) {
        progressBar.visibility = View.VISIBLE // ui thread
        textView.text = getAsyncString(params).await()
        progressBar.visibility = View.GONE // ui thread
    }

    private fun getAsyncString(params: Int): Deferred<String?> =
        // 2
        coroutineScope.async(Dispatchers.IO) {
            // 3
            val resp: String?
            resp = try {
                val time = params.times(1000)
                time.toLong().let { Thread.sleep(it / 2) }
                "Android was sleeping for $params seconds"
            } catch (e: InterruptedException) {
                e.printStackTrace()
                e.message
            } catch (e: Exception) {
                e.printStackTrace()
                e.message
            }
            return@async resp
        }
}