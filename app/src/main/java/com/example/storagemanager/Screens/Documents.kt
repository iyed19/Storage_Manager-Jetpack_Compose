package com.example.storagemanager.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.storagemanager.Components.DocumentNavBar
import com.example.storagemanager.Data.Product.ProductViewModel

@Composable
fun DocumentsScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    //prdViewModel: ProductViewModel
) {
    DocumentNavBar(navController)
}