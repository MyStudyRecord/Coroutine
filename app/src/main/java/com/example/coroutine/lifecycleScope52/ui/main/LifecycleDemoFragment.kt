package com.example.coroutine.lifecycleScope52.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutine.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LifecycleDemoFragment : Fragment() {

    companion object {
        fun newInstance() = LifecycleDemoFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        lifecycleScope.launch(Dispatchers.IO) {
            Log.i("MyTag","thread is : ${Thread.currentThread().name}")
        }


        //활동수명주기 동안 한번만 발생해야하는 장기 실행 작업이 있는경우 이걸씀
        lifecycleScope.launchWhenCreated {

        }
        //이 경우 코루틴은 활동 또는 프래그먼트가 시작될때 시작됨
        lifecycleScope.launchWhenStarted {

        }
        //앱이 사용자와 상호 작용하는 상태, 장기간 실행 되는 작업을 시작해야 하는 경우 사용
        lifecycleScope.launchWhenResumed {

        }
    }

}