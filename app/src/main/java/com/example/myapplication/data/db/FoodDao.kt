package com.example.myapplication.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.db.model.Food

@Dao
interface FoodDao {

    @Insert
    fun insertFood(food: Food)

    @Query("SELECT * FROM food")
    fun getFoods(): LiveData<List<Food>>
}