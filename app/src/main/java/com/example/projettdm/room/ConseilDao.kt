package com.example.projettdm.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projettdm.data.Conseil

@Dao
interface ConseilDao {

    @Query("select * from conseil")
    fun getConseils(): List<Conseil>

    @Query("select * from conseil where isSynchronized=0")
    fun getConseilsToSynchronize():List<Conseil>

    @Insert
    fun addConseil(vararg conseil: Conseil)

    @Update
    fun updateConseil(conseils:List<Conseil>)
}