package com.example.coroutine.UnstructuredConcurrency49

import kotlinx.coroutines.*

//구조화되지 않은 동시성(좋지않은 사용방법)
class UserDataManager {
    suspend fun getTotalUserCount() : Int{
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }

        //deferred.await()때문에 비동기 블록이 완료 될때까지 3초를 기다려야 함
        return count + deferred.await()
    }
}