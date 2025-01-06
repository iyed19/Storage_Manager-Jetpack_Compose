package com.example.storagemanager.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.storagemanager.R

@Composable
fun ProductNavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var showMenu by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .padding(top = 27.dp)
            .padding(start = 5.dp)
            .padding(bottom = 10.dp)
    ) {
        Row(

        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back_24px),
                contentDescription = "Sample Icon",
                modifier = Modifier
                    .size(33.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Spacer(modifier = Modifier.padding(end = 30.dp))
            Text(
                text = "Products",
                fontSize = 27.sp
            )
            //Spacer(modifier = Modifier.padding(end = 115.dp))
            Spacer(modifier = Modifier.weight(1f)) // Push content to the right
            Icon(
                painter = painterResource(id = R.drawable.search_24px),
                contentDescription = "Sample Icon",
                modifier = Modifier
                    .size(33.dp)
            )
            Spacer(modifier = Modifier.padding(end = 12.dp))
            Box {
                Icon(
                    painter = painterResource(id = R.drawable.more_vert_24px),
                    contentDescription = "Sample Icon",
                    modifier = Modifier
                        .size(33.dp)
                        .clickable { showMenu = !showMenu }
                )

                // DropdownMenu for the list of choices
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false },
                    modifier = Modifier
                        .wrapContentSize()
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(
                                "Add new category",
                                fontSize = 17.sp
                            )
                        },
                        onClick = {
                            navController.navigate("addCategory")
                            showMenu = false
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                "Add new product",
                                fontSize = 17.sp
                            )
                        },
                        onClick = {
                            navController.navigate("addProduct")
                            showMenu = false
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                "...",
                                fontSize = 17.sp
                            )
                        },
                        onClick = {
                            // Action for the third option
                            showMenu = false
                        }
                    )
                }
            }
        }
    }
}