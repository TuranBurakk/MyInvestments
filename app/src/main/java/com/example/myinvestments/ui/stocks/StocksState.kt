package com.example.myinvestments.ui.stocks

import com.example.myinvestments.data.entity.Result

data class StocksState(
    val isLoading : Boolean = false,
    val stocks : List<Result> = emptyList(),
    val error : String = ""
)