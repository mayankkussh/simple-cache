package com.mayankkusshl.simplecache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mayankkusshl.simplecache.CacheDao
import com.mayankkusshl.simplecache.SimpleCache

@Database(entities = arrayOf(SimpleCache::class), version = 1)

abstract class CacheDatabase : RoomDatabase() {
    abstract fun cacheDao(): CacheDao
}