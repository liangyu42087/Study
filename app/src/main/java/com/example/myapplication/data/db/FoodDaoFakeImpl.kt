package com.example.myapplication.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.model.Food

class FoodDaoFakeImpl : FoodDao {

    private val foodList = mutableListOf<Food>()
    private val foods = MutableLiveData<List<Food>>()

    init {
        foods.value = foodList
    }

    override fun insertFood(food: Food) {
        foodList.add(food)
        foods.value = foodList
    }

    override fun getFoods() = foods as LiveData<List<Food>>
}