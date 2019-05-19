package com.example.myapplication.data.db

class DatabaseFakeImpl private constructor() : Database {

    companion object {
        @Volatile
        private var instance: Database? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: DatabaseFakeImpl().also {
                instance = it
            }
        }
    }

    override val foodDao = FoodDaoFakeImpl()
}