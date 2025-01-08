package com.example.storagemanager.Components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ImageInputField(onImageSelected: (Uri?) -> Unit) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        // This is called when the user selects an image
        onImageSelected(uri)
    }

    Button(
        onClick = { launcher.launch("image/*") } // Opens the image picker
    ) {
        Text("Select Image")
    }
}
