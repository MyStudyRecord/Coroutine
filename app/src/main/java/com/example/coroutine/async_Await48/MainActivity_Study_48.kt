package com.example.coroutine.async_Await48

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutine.R
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity_Study_48 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__study_48)

        //병렬 작업 방법1
        CoroutineScope(IO).launch {
            Log.i("MyTag","Calculation started....")

            //비동기 처리 async { ~~ }
            val stock1 = async { getStock1() }
            val stock2 =async { getStock2() }
            //반환값을 얻으려면 await()
            val total = stock1.await() + stock2.await()
            Log.i("MyTag","Total is $total")
        }

        //병렬 작업 방법2
        CoroutineScope(Main).launch {
            Log.i("MyTag","Calculation started....")

            //병렬 이벤트만 IO(백그라운드에서)
            val stock1 = async(IO) { getStock1() }
            val stock2 =async(IO) { getStock2() }
            //반환값을 얻으려면 await()
            val total = stock1.await() + stock2.await()
            Log.i("MyTag","Total is $total")
        }
    }
}

private suspend fun getStock1() : Int {
    delay(10000)
    Log.i("MyYag", "stock 1 returned")
    return 55000
}

private suspend fun getStock2() : Int {
    delay(8000)
    Log.i("MyYag", "stock 2 returned")
    return 35000
}