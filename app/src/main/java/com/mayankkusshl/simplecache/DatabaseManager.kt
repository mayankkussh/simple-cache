package com.mayankkusshl.simplecache

import android.content.Context
import androidx.room.Room


class DatabaseManager constructor(val context: Context) {

    val cacheDatabase = Room.databaseBuilder(
        context, CacheDatabase::class.java, "simple_cache_db"
    ).build()
}