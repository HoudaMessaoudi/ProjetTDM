package com.example.projettdm.room

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room

@SuppressLint("StaticFieldLeak")
object RoomService {
    @SuppressLint("StaticFieldLeak")
   lateinit var context: Context
    val appDatabase: AppDatabase by lazy {
       Room.databaseBuilder(context, AppDatabase::class.java,"tdm").allowMainThreadQueries().build()
    }
}