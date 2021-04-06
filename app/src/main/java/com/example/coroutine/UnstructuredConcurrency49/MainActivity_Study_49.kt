package com.example.coroutine.UnstructuredConcurrency49

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.coroutine.R
import com.example.coroutine.databinding.ActivityMainStudy49Binding
import kotlinx.coroutines.*

class MainActivity_Study_49 : AppCompatActivity() {
    lateinit var binding: ActivityMainStudy49Binding
    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main__study_49)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {

            //TextView 값을 표시 할려면 IO에서 Main으로 변경해야함
            //Main쓰레드에서 Ui값 수정 가능하기 때문
            CoroutineScope(Dispatchers.Main).launch {
                binding.tvUserMessage.text = UserDataManager().getTotalUserCount().toString()
            }

        }
    }

    private suspend fun downloadUserData(){
        for(i in 1..200000){
            withContext(Dispatchers.Main){
                binding.tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
                delay(100)
            }
        }
    }
}