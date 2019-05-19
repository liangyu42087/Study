package com.example.myapplication.data.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.model.Food

interface FoodRepository {

    fun insertFood(food: Food)

    fun getFoods(): LiveData<List<Food>>
}