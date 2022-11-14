package com.example.demowebsankul.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTENCE : UserDatabase? = null

        fun getDatabase(context: Context) : UserDatabase {
            val temInstance = INSTENCE
            if (temInstance != null){
                return temInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTENCE = instance
                return instance
            }
        }
    }

}