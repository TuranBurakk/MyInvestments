package com.example.myinvestments.ui

sealed class Screen(var route : String) {

    object StocksScreen : Screen("stocks_screen")
}