package com.example.storagemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.storagemanager.Data.Category.CategoryViewModel
import com.example.storagemanager.Data.Product.ProductViewModel
import com.example.storagemanager.Screens.AddCategoryScreen
import com.example.storagemanager.Screens.AddProductScreen
import com.example.storagemanager.Screens.DocumentsScreen
import com.example.storagemanager.Screens.HomeScreen
import com.example.storagemanager.Screens.ProductsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val prdViewModel: ProductViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory(application)
            )
            val ctgViewModel: CategoryViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory(application)
            )
            AppNavigation(prdViewModel, ctgViewModel)
        }
    }
}

@Composable
fun AppNavigation(prdViewModel: ProductViewModel, ctgViewModel: CategoryViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {

        composable("Products") { ProductsScreen(
            navController = navController,
            prdViewModel = prdViewModel,
            ctgViewModel = ctgViewModel
        ) }

        composable("addCategory") { AddCategoryScreen(
            navController = navController,
            ctgViewModel = ctgViewModel
        ) }

        composable("addProduct") { AddProductScreen(
            navController = navController,
            prdViewModel = prdViewModel,
            ctgViewModel = ctgViewModel
        ) }

        composable("Documents") { DocumentsScreen(
            navController = navController
//            prdViewModel = prdViewModel
        ) }

        composable("home") { HomeScreen(navController) }
        //composable("welcome") { WelcomeScreen(navController) }
    }
}