package com.example.myinvestments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myinvestments.ui.Screen
import com.example.myinvestments.ui.stocks.views.StocksScreen
import com.example.myinvestments.ui.theme.MyInvestmentsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyInvestmentsTheme {
               Surface(color = Color.DarkGray) {
                   val navController = rememberNavController()
                   NavHost(navController = navController,
                       startDestination = Screen.StocksScreen.route){
                       composable(route = Screen.StocksScreen.route){
                           StocksScreen(navController)
                       }
                   }
               }
            }
        }
    }
}

