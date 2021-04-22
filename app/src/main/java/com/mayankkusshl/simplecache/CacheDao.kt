package com.mayankkusshl.simplecache

import androidx.room.*
import com.mayankkusshl.simplecache.SimpleCache

@Dao
interface CacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCache(cache: SimpleCache)

    @Query("SELECT * FROM simplecache WHERE `key` = :key")
    fun getCache(key: String): SimpleCache

    @Query("DELETE FROM simplecache WHERE `key` = :key")
    fun deleteCache(key: String)
}