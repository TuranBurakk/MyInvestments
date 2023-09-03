package com.example.myinvestments.ui.stocks.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.myinvestments.data.entity.Result
import com.example.myinvestments.ui.stocks.StocksViewModel
import com.example.myinvestments.ui.theme.ExpandableCardView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StocksRow(
    stocks: Result
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly,

        ) {

            Column {
                ExpandableCardView(
                    title = stocks.code ?: "",
                    titleStyle = MaterialTheme.typography.labelMedium,
                    hacim = stocks.hacimstr ?: "" ,
                    rate = stocks.rate.toString(),
                    lastPrice = stocks.lastpricestr.toString(),
                    descriptionStyle = MaterialTheme.typography.labelSmall,
                    descriptionMaxLines = 4,
                    shape = ShapeDefaults.Medium,
                    padding = 4.dp
                ){




                }

            }

        }
    }

}


