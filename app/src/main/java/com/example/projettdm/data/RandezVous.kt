package com.example.projettdm.data
import java.io.Serializable
import java.time.LocalDate
import java.util.*

data class RandezVous (
    var id_medecin:String
    ,var nom_medecin:String,
    var prenom_medecin:String,
    var id_client:String,
    var date:String):Serializable{

}