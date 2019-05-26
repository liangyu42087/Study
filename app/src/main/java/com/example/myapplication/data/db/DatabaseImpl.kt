package com.example.myapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.db.model.Food

@Database(
    entities = [Food::class],
    version = 1
)
abstract class DatabaseImpl : com.example.myapplication.data.db.Database, RoomDatabase() {

    companion object {
        @Volatile
        private var instance: com.example.myapplication.data.db.Database? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(
                context.applicationContext,
                DatabaseImpl::class.java,
                "foodDatabase.db")
                .build()
                .also {
                    instance = it
                }
        }
    }

    abstract override val foodDao: FoodDao
}