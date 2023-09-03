package com.example.myinvestments.domain.use_case.get_stocks

import com.example.myinvestments.data.entity.Result
import com.example.myinvestments.data.remote.Repository
import com.example.myinvestments.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetStocksUseCase @Inject constructor(
    private val repository: Repository
){

    fun getStocks(): Flow<Resource<List<Result>>> = flow{
        try {
            emit(Resource.Loading())
            val stockList = repository.getStocks()
            if (stockList.success == true){
                emit(Resource.Success(stockList.result))
            }else{
                emit(Resource.Error("Error"))
            }
        }catch (e : IOError){
            emit(Resource.Error("No internet connection"))
        }
    }
}