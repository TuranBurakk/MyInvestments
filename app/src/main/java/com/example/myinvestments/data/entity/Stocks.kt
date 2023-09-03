package com.example.myinvestments.data.entity

import com.google.gson.annotations.SerializedName

data class Stocks(
    @SerializedName("success" )var success : Boolean?          = null,
    @SerializedName("result"  )var result  : ArrayList<Result> = arrayListOf()
)
