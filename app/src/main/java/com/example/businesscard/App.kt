package com.example.businesscard

import android.app.Application
import com.example.businesscard.data.AppDataBAse
import com.example.businesscard.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDataBAse.getDataBase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}