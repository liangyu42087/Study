package com.example.myapplication.data.db

import androidx.lifecycle.LiveData
import com.example.myapplication.data.model.Food

interface FoodDao {

    fun insertFood(food: Food)

    fun getFoods(): LiveData<List<Food>>
}