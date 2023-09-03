package com.example.myinvestments.data.entity

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("rate"         ) var rate         : Double? = null,
    @SerializedName("lastprice"    ) var lastprice    : Double? = null,
    @SerializedName("lastpricestr" ) var lastpricestr : String? = null,
    @SerializedName("hacim"        ) var hacim        : Double? = null,
    @SerializedName("hacimstr"     ) var hacimstr     : String? = null,
    @SerializedName("text"         ) var text         : String? = null,
    @SerializedName("code"         ) var code         : String? = null
)
