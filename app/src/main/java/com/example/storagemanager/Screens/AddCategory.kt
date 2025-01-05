package com.example.storagemanager.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.storagemanager.Data.ProductViewModel

@Composable
fun AddCategoryScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
        ) {
            Text(
                "Add Category",
                fontSize = 25.sp
            )
            NavigationBar {

            }
        }
    }
}