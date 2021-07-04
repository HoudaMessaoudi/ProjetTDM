package com.example.projettdm.data

import com.google.gson.annotations.SerializedName
import java.io.File
import java.io.Serializable

data class Medecin (val _id:String,
                    val nom:String,
                    val prenom:String,
                    val num:String,
                    val password:String,
                    val speciality:String,
                    val coor_longitude : Float,
                    val coor_lattitude : Float,
                    val picture:String):Serializable {
}