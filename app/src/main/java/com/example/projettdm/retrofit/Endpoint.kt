package com.example.projettdm.retrofit

import com.example.projettdm.data.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*

interface Endpoint {

    @POST("api/conseil")
    fun addconseil(@Body conseil: Conseil):Call<String>

    @POST("api/conseil/mult")
    fun addconseils(@Body conseil: List<Conseil>):Call<String>

    @GET("api/medecin")
    fun getmedecin():Call<List<Medecin>>

    @GET("api/traitement")
    fun gettraitement():Call<List<Traitement>>

    @GET("api/rdv")
    fun getrdv():Call<List<RandezVous>>

    @POST("api/client/auth")
    fun login(@Body client:Client):Call<Client>

    @GET("api/edt")
    fun getedv(@Query("id") id_medecin:String):Call<Array<Edt>>
}