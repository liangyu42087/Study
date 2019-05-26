package com.example.myapplication.data.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.db.model.Food

interface FoodRepository {

    suspend fun insertFood(food: Food)

    fun getFoods(): LiveData<List<Food>>
}