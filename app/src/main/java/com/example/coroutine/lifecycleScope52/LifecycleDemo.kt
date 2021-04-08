package com.example.coroutine.lifecycleScope52

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.example.coroutine.R
import com.example.coroutine.lifecycleScope52.ui.main.LifecycleDemoFragment
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LifecycleDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lifecycle_demo_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LifecycleDemoFragment.newInstance())
                .commitNow()
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        lifecycleScope.launch(IO) {
            Log.i("MyTag","thread is : ${Thread.currentThread().name}")
            delay(5000)
            progressBar.visibility = View.VISIBLE
            delay(10000)
            progressBar.visibility = View.GONE
        }
    }
}