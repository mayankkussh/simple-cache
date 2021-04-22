package com.mayankkusshl.simplecache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class SimpleCache(
    @ColumnInfo
    @PrimaryKey var key: String,
    @ColumnInfo(name = "data") var data: String
)