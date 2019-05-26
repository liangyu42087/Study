package com.example.myapplication.ui.food

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.db.model.Food
import com.example.myapplication.data.repository.FoodRepository
import kotlinx.coroutines.launch

class FoodViewModel(private val repository: FoodRepository) : ViewModel() {

    private val errorMessage = MutableLiveData<String>()

    fun insertFood(foodName: String, price: String) = viewModelScope.launch {
        try {
            val food = Food(foodName = foodName, price = price.toDouble())
            repository.insertFood(food)
        } catch (numberFormatException: NumberFormatException) {
            errorMessage.value = numberFormatException.localizedMessage
        }
    }

    fun getFoods() = repository.getFoods()

    fun getError() = errorMessage as LiveData<String>
}

