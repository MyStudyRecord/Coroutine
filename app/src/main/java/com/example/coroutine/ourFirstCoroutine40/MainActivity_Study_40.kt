package com.example.coroutine.ourFirstCoroutine40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.coroutine.R
import com.example.coroutine.databinding.ActivityMainStudy40Binding
import kotlinx.coroutines.*

class MainActivity_Study_40 : AppCompatActivity() {
    lateinit var binding : ActivityMainStudy40Binding
    private var count =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main__study_40)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {
            //이 작업은 백그라운드 스레드에서 실행해야하므로 Dispatchers.IO를 context로 제공
            //Dispatchers.Main : 코루틴이 Main Thread에서 실행 됩니다, UI함수 호출, 일시 중단 호출과 같은 작고 가벼운 작업에만 사용
            //Dispatchers.IO : 가벼우면서 동시에 처리해야 하는 작업의 갯수가 많은 경우에 Dispatchers.IO 를 사용
            //Dispatchers.Default : 대기시간이 없고 지속적으로 CPU의 작업을 필요로 하는 무거운 작업에 사용
            //Dispatchers.Unconfined : GlobalScope와 함께 사용됨

            //launch : 반환값 없음
            //async : 반환값이 필요하다면 사용
            //produce : 요소의 흐름을 생산하는 코루틴을 위한 것
            //runblocking : ReceiveChannel의 인스턴스를 반환합니다, 개발에서는 주로 테스트용으로 사용
            CoroutineScope(Dispatchers.IO).launch {
                 downloadUserData()
             }

        }
    }

    //suspend를 사용해여 withContext에 오류가 안난다
    private suspend fun downloadUserData(){
        for(i in 1..200000){
            withContext(Dispatchers.Main){
                binding.tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
                delay(100)
            }
        }
    }
}