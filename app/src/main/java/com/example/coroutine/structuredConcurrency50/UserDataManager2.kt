package com.example.coroutine.structuredConcurrency50

import kotlinx.coroutines.*

//구조화된 동시성
class UserDataManager2 {
    var count = 0
    lateinit var deferred : Deferred<Int>
    suspend fun getTotalUserCount() : Int {


        coroutineScope {
            //Dispatcher을 사용하지 않을 경우 코루틴은 메인 스레드에서 기본 실행
            launch(Dispatchers.IO) {
                delay(1000)
                count = 50
            }
            deferred = async(Dispatchers.IO) {
                delay(3000)
                return@async 70
            }
        }

        //coroutinewScope는 자식 코루틴이 완료 될때까지 기다린다, 때문에 50+70=120
        return count + deferred.await()
    }

}