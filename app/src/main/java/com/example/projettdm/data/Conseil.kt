package com.example.projettdm.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName="conseil")
data class Conseil(
                var Contenu:String,
                var medecinId:String,
                var clientId:String,
                var isSynchronized:Boolean=false) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int?=null
}