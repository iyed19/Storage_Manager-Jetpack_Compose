package com.example.storagemanager.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val products = prdViewModel.ListofProducts
    val selectedProduct = prdViewModel.selectedProduct

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        ProductNavBar(navController)

        Column(
            modifier = Modifier
                .padding(top = 85.dp)
                .padding(bottom = 25.dp)
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                items(products) { currentProduct ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp)
                            .padding(end = 15.dp)
                            .padding(7.dp),
                            //.clickable { prdViewModel.selectProduct(currentProduct) },
                            //.clickable { navController.navigate("...") },
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "${currentProduct.title} ( ${ctgViewModel.getCategoryNameById(currentProduct.category)} )" ?: "No Title",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "${currentProduct.price} $" ?: "0.00",
                                fontSize = 20.sp
                            )
                            Text(
                                //text = "${currentProduct.quantity} pieces available " ?: "0",
                                text = buildAnnotatedString {
                                    append("${currentProduct.quantity} pieces available ")

                                    if (currentProduct.quantity == 0) {
                                        withStyle(style = SpanStyle(color = Color.Red)) {
                                            append(" Out Of Stock")
                                        }
                                    } else if (currentProduct.quantity <= 5) {
                                        withStyle(style = SpanStyle(color = Color(0xFFFFA500))) { // Orange color
                                            append(" Low Stock")
                                        }
                                    }
                                },
                                fontSize = 19.sp
                            )
                        }
                    }
                }
            }
        }
    }

}