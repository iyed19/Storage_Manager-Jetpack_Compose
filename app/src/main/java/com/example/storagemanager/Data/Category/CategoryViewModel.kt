package com.example.storagemanager.Data.Category

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.storagemanager.Data.AppRoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppRoomDB.getDatabase(application)

    private val categoryDao = database.categoryDao()

    var inputCategoryName by mutableStateOf("")
        private set

    var ListofCategories = mutableStateListOf<Category>()
        private set


    init {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = categoryDao.getAllCategories()
            ListofCategories.addAll(categories)
        }
    }

    fun onCategoryNameChange(newName: String) {
        inputCategoryName = newName
    }


    fun addCategory() {
        val category = Category(
            name = inputCategoryName
        )
        viewModelScope.launch(Dispatchers.IO) {
            categoryDao.insertCategory(category)
            val updatedCategories = categoryDao.getAllCategories()
            ListofCategories.clear()
            ListofCategories.addAll(updatedCategories)
        }
        clearFields()
    }


    fun clearFields(){
        inputCategoryName = ""
    }

}