@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.storagemanager.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
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

    val inputPrdTitle = prdViewModel.inputPrdTitle
    val inputPrdPrice = prdViewModel.inputPrdPrice
    val inputPrdQuantity = prdViewModel.inputPrdQuantity
    var expanded by remember { mutableStateOf(false) }
    val selectedCategory = prdViewModel.inputPrdCategory
    val categoryList = ctgViewModel.ListofCategories
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
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(bottom = 15.dp)
            ) {
                Text(
                    "Add Product Page",
                    fontSize = 30.sp
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(bottom = 10.dp)
            ) {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = categoryList.find { it.id == selectedCategory }?.name ?: "Select category",
                        onValueChange = {}, // Disable manual input
                        label = {
                            Text(
                                "Select category",
                                fontSize = 20.sp
                            )
                        },
                        readOnly = true, // Prevent editing
                        modifier = Modifier
                            .menuAnchor(),
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        }
                    )

                    // Dropdown menu
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .padding(start = 10.dp)
                    ) {
                        categoryList.forEach { category ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        category.name,
                                        fontSize = 19.sp
                                    )
                                },
                                onClick = {
                                    prdViewModel.onPrdCategoryChange(category.id) // Update the selected category
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(bottom = 10.dp)
            ) {
                OutlinedTextField(
                    value = inputPrdTitle,
                    onValueChange = { text ->
                        val capitalizedText = text.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
                        prdViewModel.onPrdTitleChange(capitalizedText)
                    },
                    label = {
                        Text(
                            "Product title",
                            fontSize = 20.sp
                        )
                    },
                    modifier = Modifier
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(bottom = 10.dp)
            ) {
                OutlinedTextField(
                    value = inputPrdPrice,
                    onValueChange = { newValue ->
                        if (newValue.isEmpty() || newValue.matches(Regex("^\\d*\\.?\\d*\$"))) {
                            prdViewModel.onPrdPriceChange(newValue)
                        }
                    },
                    label = {
                        Text(
                            "Product price",
                            fontSize = 20.sp
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    ),
                    modifier = Modifier
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(bottom = 10.dp)
            ) {
                OutlinedTextField(
                    value = inputPrdQuantity,
                    onValueChange = { newValue ->
                        if (newValue.isEmpty() || newValue.all { it.isDigit() }) {
                            prdViewModel.onPrdQuantityChange(newValue)
                        }
                    },
                    label = {
                        Text(
                            "Product quantity",
                            fontSize = 20.sp
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Button(
                    onClick = {
                        if (
                            selectedCategory != 0 &&
                            inputPrdTitle.isNotBlank() &&
                            inputPrdPrice.isNotBlank() &&
                            inputPrdQuantity.isNotBlank()
                        ) {
                            prdViewModel.addProduct()
                            Toast.makeText(
                                context,
                                "Product added successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                context,
                                "Please enter all the data",
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