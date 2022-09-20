package com.kenbu.marssale.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarsApi {
    private const val BASE_URL = "https://mars.udacity.com/"

    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}