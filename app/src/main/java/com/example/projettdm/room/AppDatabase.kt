package com.example.projettdm.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projettdm.data.Conseil
import com.example.projettdm.room.ConseilDao


@Database(entities = [Conseil::class],version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getConseilDao(): ConseilDao
    //abstract fun addConseil():ConseilDao
    //abstract fun getConseilsToSynchronize():ConseilDao
}