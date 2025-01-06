package com.example.storagemanager.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.storagemanager.R

@Composable
fun DocumentNavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
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
                text = "Documents",
                fontSize = 27.sp
            )
            Spacer(modifier = Modifier.padding(end = 115.dp))
            Icon(
                painter = painterResource(id = R.drawable.search_24px),
                contentDescription = "Sample Icon",
                modifier = Modifier
                    .size(33.dp)
            )
            Spacer(modifier = Modifier.padding(end = 12.dp))
            Icon(
                painter = painterResource(id = R.drawable.more_vert_24px),
                contentDescription = "Sample Icon",
                modifier = Modifier
                    .size(33.dp)
            )
        }
    }
}