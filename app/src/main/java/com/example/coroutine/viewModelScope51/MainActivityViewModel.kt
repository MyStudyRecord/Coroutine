package com.example.coroutine.viewModelScope51

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel(){

    //Job = coroutines의 상태를 가지고 있다
//    private val myJob = Job()
//    private val myScope = CoroutineScope(Dispatchers.IO + myJob)

    private var userRepository = UserRepository()
    var users : MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData(){
        viewModelScope.launch {
            var result : List<User>?=null
            withContext(Dispatchers.IO){
                result = userRepository.getUsers()
            }

            users.value = result
        }
    }

    //viewmodel이 메모리에서 지워질때 실행되는 메서드
    //viewmodelscope를 사용하면 삭제등이 자동으로 이루어짐
//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//    }
}