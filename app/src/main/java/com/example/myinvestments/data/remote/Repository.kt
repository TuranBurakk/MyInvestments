package com.example.myinvestments.data.remote

import com.example.myinvestments.data.entity.Stocks
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getStocks():Stocks{
        return remoteDataSource.getStocks()
    }
}