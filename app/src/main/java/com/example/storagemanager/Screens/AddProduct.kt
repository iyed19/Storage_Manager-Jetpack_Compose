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
import com.example.storagemanager.Components.ProductNavBar
import com.example.storagemanager.Data.Category.CategoryViewModel
import com.example.storagemanager.Data.Product.ProductViewModel

@Composable
fun AddProductScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    prdViewModel: ProductViewModel,
    ctgViewModel: CategoryViewModel
) {
    Column(
        modifier = Modifier
    ) {
        ProductNavBar(navController)

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