package com.example.storagemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.storagemanager.Data.ProductViewModel
import com.example.storagemanager.Screens.AddCategoryScreen
import com.example.storagemanager.Screens.AddProductScreen
import com.example.storagemanager.Screens.HomeScreen
import com.example.storagemanager.ui.theme.StorageManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: ProductViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory(application)
            )
            AppNavigation(viewModel)
        }
    }
}

@Composable
fun AppNavigation(viewModel: ProductViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("addCategory") { AddCategoryScreen(navController = navController, viewModel = viewModel) }
        composable("addProduct") { AddProductScreen(navController = navController, viewModel = viewModel) }
        composable("home") { HomeScreen(navController) }
        //composable("welcome") { WelcomeScreen(navController) }
    }
}