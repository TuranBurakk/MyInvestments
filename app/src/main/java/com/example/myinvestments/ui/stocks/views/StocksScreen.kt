package com.example.myinvestments.ui.stocks.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myinvestments.data.entity.Result
import com.example.myinvestments.data.entity.Stocks
import com.example.myinvestments.data.remote.ApiService
import com.example.myinvestments.data.remote.RemoteDataSource
import com.example.myinvestments.data.remote.Repository
import com.example.myinvestments.domain.use_case.get_stocks.GetStocksUseCase
import com.example.myinvestments.ui.stocks.StocksViewModel
import com.example.myinvestments.ui.theme.MyInvestmentsTheme

@Composable
fun StocksScreen(
    navController: NavController,
    viewModel : StocksViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){

        Column {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement  =  Arrangement.SpaceEvenly){
                Text(text = "code", color = Color.White)
                Text(text = "Son Değer TL", color = Color.White)
                Text(text = "Hacim", color = Color.White)
            }
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.stocks){stocks ->
                    StocksRow(stocks = stocks)
                }
            }

        }

    }
}







