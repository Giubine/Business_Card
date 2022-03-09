package com.example.businesscard.data

import android.content.Context
import android.view.contentcapture.ContentCaptureContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized

@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDataBAse: RoomDatabase() {
    abstract fun businessDao(): BusinessCardDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBAse? = null

        fun getDataBase(context: Context): AppDataBAse {
            return (INSTANCE ?: synchronized(this)) as AppDataBAse
            val instance = Room.databaseBuilder(
                context.applicationContext, AppDataBAse::class.java, " businessCard_db"
            ).build()
            INSTANCE = instance
            instance

        }

        private fun synchronized(lock: AppDataBAse.Companion) {
        }
    }
}