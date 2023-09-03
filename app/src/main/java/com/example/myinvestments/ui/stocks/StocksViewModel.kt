package com.example.myinvestments.ui.stocks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myinvestments.domain.use_case.get_stocks.GetStocksUseCase
import com.example.myinvestments.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StocksViewModel @Inject constructor(
private val getStocksUseCase: GetStocksUseCase
):ViewModel() {

    private val _state = mutableStateOf<StocksState>(StocksState())
    val state : State<StocksState> = _state

    private var job : Job? = null

    init{
        getStocks()
    }


    private fun getStocks(){
        job?.cancel()

        job = getStocksUseCase.getStocks().onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = StocksState(stocks = it.data ?: emptyList())
                }
                is Resource.Loading ->{
                    _state.value = StocksState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = StocksState(error = it.message ?: "error")
                }
            }
        }.launchIn(viewModelScope)
    }
}