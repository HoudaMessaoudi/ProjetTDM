package com.example.projettdm.retrofit

import com.example.projettdm.data.Conseil
import com.example.projettdm.data.Medecin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Endpoint {

    @POST("api/conseil")
    fun addconseil(@Body conseil: Conseil):Call<String>

    @POST("api/conseil/mult")
    fun addconseils(@Body conseil: List<Conseil>):Call<String>

    @GET("api/medecin")
    fun getmedecin():Call<List<Medecin>>


}