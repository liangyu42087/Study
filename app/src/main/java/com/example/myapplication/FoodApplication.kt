package com.example.myapplication

import android.app.Application
import com.example.myapplication.data.db.Database
import com.example.myapplication.data.db.DatabaseFakeImpl
import com.example.myapplication.data.db.DatabaseImpl
import com.example.myapplication.data.db.FoodDao
import com.example.myapplication.data.repository.FoodRepository
import com.example.myapplication.data.repository.FoodRepositoryImpl
import com.example.myapplication.ui.food.FoodViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class FoodApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseImpl.getInstance(applicationContext) }
        bind<FoodDao>() with singleton { instance<Database>().foodDao }
        bind<FoodRepository>() with singleton { FoodRepositoryImpl.getInstance(instance()) }
        bind() from provider { FoodViewModelFactory(instance()) }
    }
}