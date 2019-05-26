package com.example.myapplication.data.repository

import com.example.myapplication.data.db.FoodDao
import com.example.myapplication.data.db.model.Food
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodRepositoryImpl private constructor(private val foodDao: FoodDao) : FoodRepository {

    companion object {
        @Volatile
        private var instance: FoodRepository? = null

        fun getInstance(foodDao: FoodDao) =
            instance ?: synchronized(this) {
                instance ?: FoodRepositoryImpl(foodDao).also {
                    instance = it
                }
            }
    }

    override suspend fun insertFood(food: Food) {
        withContext(Dispatchers.IO) {
            foodDao.insertFood(food)
        }
    }

    override fun getFoods() = foodDao.getFoods()

}