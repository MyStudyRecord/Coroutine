package com.example.coroutine.codingChallenge43

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutine.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CodingChallenge43 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coding_challenge43)

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("MyTag","Hello from ${Thread.currentThread().name}")
        }


        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MyTag","Hello from ${Thread.currentThread().name}")
        }
    }
}