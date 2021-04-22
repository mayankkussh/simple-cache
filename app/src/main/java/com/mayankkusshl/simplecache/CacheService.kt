package com.mayankkusshl.simplecache

import com.google.gson.Gson
import io.reactivex.rxjava3.core.Observable

class CacheService  constructor(private val gson: Gson, private val cacheDao: CacheDao) {

    fun <T> getDataFromCache(cacheKey: CacheKey, type: Class<T>): Observable<T> {
        return observable { emitter ->
            val className = type.simpleName
            val dataFromDb = getCache(cacheKey)
            try {
                val data = gson.fromJson<T>(dataFromDb, type)
                emitter.onSuccessObservable(data!!)
            } catch (e: Exception) {
                emitter.onErrorObservable(getCacheMissError(className))
            }
        }
    }

    private fun getCache(cacheKey: CacheKey): String? {
        return cacheDao.getCache(cacheKey.name).data
    }

    private fun setCache(key: String, data: String) {
        cacheDao.insertCache(SimpleCache(key, data))
    }

    fun <T> cacheData(data: T, cacheKey: CacheKey) {
        observable<T> {
            setCache(cacheKey.name, gson.toJson(data))
        }.subscribe()
    }


    private fun getCacheMissError(className: String): Throwable {
        return Throwable("Cache miss for $className")
    }
}