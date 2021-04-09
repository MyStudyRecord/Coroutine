package com.example.coroutine.viewModelScope51

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.coroutine.R

class MainActivity_Study_51 : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__study_51)

        //수명주기 소유자는 MainActivity
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

//        mainActivityViewModel.getUserData()
        mainActivityViewModel.users.observe(this, Observer {
            myUsers-> myUsers.forEach{
                Log.i("MyTag","name is ${it.name}")
        }
        })
    }
}