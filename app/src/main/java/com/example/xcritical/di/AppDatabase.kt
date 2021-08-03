package com.example.xcritical.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.xcritical.dataBase.DAO.ProjectDbDao
import com.example.xcritical.dataBase.entities.ProjectDb

@Database(entities = arrayOf(ProjectDb::class),version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDbDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database_name"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}