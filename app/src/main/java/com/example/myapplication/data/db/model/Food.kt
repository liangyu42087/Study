package com.example.myapplication.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class Food(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "foodName") val foodName: String,
    @ColumnInfo(name = "price") val price: Double)