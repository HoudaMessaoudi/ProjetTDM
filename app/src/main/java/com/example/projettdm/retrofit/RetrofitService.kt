package com.example.projettdm.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val endpoint : Endpoint by lazy {
        Retrofit.Builder().baseUrl("http://59baff666a45.ngrok.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Endpoint::class.java)
    }
    }