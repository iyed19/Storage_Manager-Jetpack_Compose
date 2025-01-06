package com.example.storagemanager.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.storagemanager.Components.ProductNavBar
import com.example.storagemanager.Data.Category.CategoryViewModel
import com.example.storagemanager.Data.Product.ProductViewModel

@Composable
fun ProductsScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    prdViewModel: ProductViewModel,
    ctgViewModel: CategoryViewModel
) {
    ProductNavBar(navController)
}