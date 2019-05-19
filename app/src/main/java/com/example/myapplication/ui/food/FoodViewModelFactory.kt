package com.example.myapplication.ui.food

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repository.FoodRepository

class FoodViewModelFactory(private val foodRepository: FoodRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FoodViewModel(foodRepository) as T
    }
}