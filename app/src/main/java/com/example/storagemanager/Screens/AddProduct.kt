package com.example.storagemanager.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.storagemanager.Data.ProductViewModel

@Composable
fun AddProductScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel
) {
    Column(
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier
                .padding(top = 50.dp)
        ) {
            Text(
                "Add Product Page",
                fontSize = 30.sp
            )
        }
    }
}