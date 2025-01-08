//package com.example.storagemanager.Components
//
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.unit.dp
//import coil3.Uri
//import coil3.compose.AsyncImage
//
//@Composable
//fun ImagePickerDemo() {
//    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        modifier = Modifier.padding(16.dp)
//    ) {
//        // Button to pick an image
//        ImageInputField { uri ->
//            selectedImageUri = uri
//        }
//
//        // Show the selected image if available
//        selectedImageUri?.let { uri ->
//            AsyncImage(
//                model = uri,
//                contentDescription = "Selected Image",
//                modifier = Modifier
//                    .size(200.dp)
//                    .clip(RoundedCornerShape(16.dp))
//                    .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
//            )
//        } ?: Text("No image selected")
//    }
//}
