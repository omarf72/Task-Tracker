package com.example.tasktracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 4, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskInfoDao(): TaskInfoDao

    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase {

            return INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(context.applicationContext.applicationContext,
                    TaskDatabase::class.java,"task_database"

                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE=instance

                return instance
            }



            /* synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        com.example.tasktracker.TaskDatabase::class.java,
                        "tasks_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }*/


        }
    }
}
