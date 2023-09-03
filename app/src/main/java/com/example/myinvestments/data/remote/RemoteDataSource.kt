package com.example.myinvestments.data.remote

import com.example.myinvestments.data.entity.Stocks
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getStocks():Stocks{
        return apiService.getStocks()
    }
}