package com.example.myapplication.util

import com.example.myapplication.data.db.DatabaseFakeImpl
import com.example.myapplication.data.repository.FoodRepositoryImpl
import com.example.myapplication.ui.food.FoodViewModelFactory

object InjectUtil {

    fun providesFoodViewModelFactory(): FoodViewModelFactory {
        val foodRepository = FoodRepositoryImpl.getInstance(DatabaseFakeImpl.getInstance().foodDao)
        return FoodViewModelFactory(foodRepository)
    }
}