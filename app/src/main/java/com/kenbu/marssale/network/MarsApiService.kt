package com.kenbu.marssale.network

import com.kenbu.marssale.model.RealEstateModel
import retrofit2.Call
import retrofit2.http.GET

interface MarsApiService {
    @GET("realestate")
    fun getProperties(): Call<ArrayList<RealEstateModel>>
}