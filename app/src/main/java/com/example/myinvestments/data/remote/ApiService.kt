package com.example.myinvestments.data.remote

import com.example.myinvestments.data.entity.Stocks
import com.example.myinvestments.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("economy/hisseSenedi")
    suspend fun getStocks():Stocks
}