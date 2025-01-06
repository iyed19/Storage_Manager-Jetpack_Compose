package com.example.storagemanager.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.storagemanager.Components.ProductNavBar
import com.example.storagemanager.Data.Category.CategoryViewModel


@Composable
fun AddCategoryScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    ctgViewModel: CategoryViewModel
) {

    val inputCategory = ctgViewModel.inputCategoryName
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ProductNavBar(navController)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
                .padding(top = 65.dp)
        ){
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(bottom = 50.dp)
            ) {
                Text(
                    "Add Category",
                    fontSize = 25.sp
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(bottom = 10.dp)
            ) {
                OutlinedTextField(
                    value = inputCategory,
                    onValueChange = { text ->
                        ctgViewModel.onCategoryNameChange(text)
                    },
                    label = {
                        Text(
                            "Category name",
                            fontSize = 20.sp
                        )
                    },
                    modifier = Modifier
                )
            }

            Row(

            ) {
                Button(
                    onClick = {
                        if (inputCategory.isNotBlank()) {
                            ctgViewModel.addCategory()
                            Toast.makeText(
                                context,
                                "Category added successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                context,
                                "Please enter category name",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    },
                    modifier = Modifier
                        .width(255.dp)
                        .padding(start = 110.dp)
                        .padding(bottom = 10.dp)
                ) {
                    Text(
                        "Add",
                        fontSize = 21.sp
                    )
                }
            }
        }

    }
}