package com.example.storagemanager.Data.Product

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.storagemanager.Data.AppRoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AppRoomDB.getDatabase(application)

    private val productDao = database.productDao()

    var inputPrdCategory by mutableStateOf(0)
        private set

    var inputPrdTitle by mutableStateOf("")
        private set

    var inputPrdPrice by mutableStateOf("")
        private set

    var inputPrdQuantity by mutableStateOf("")
        private set

    var ListofProducts = mutableStateListOf<Product>()
        private set

    var selectedProduct: Product? by mutableStateOf(null)
        private set


    init {
        viewModelScope.launch(Dispatchers.IO) {
            val products = productDao.getAllProducts()
            ListofProducts.addAll(products)
        }
    }


    fun onPrdCategoryChange(newCategoryId: Int) {
        inputPrdCategory = newCategoryId
    }

    fun onPrdTitleChange(newTitle: String) {
        inputPrdTitle = newTitle
    }

    fun onPrdPriceChange(newPrice: String) {
        inputPrdPrice = newPrice
    }

    fun onPrdQuantityChange(newQuantity: String) {
        inputPrdQuantity = newQuantity
    }

    fun selectProduct(product: Product) {
        selectedProduct = product
        //inputPrdCategory = product.category
        inputPrdTitle = product.title
        inputPrdPrice = product.price.toString()
        inputPrdQuantity = product.quantity.toString()
    }


    fun addProduct() {
        val price = inputPrdPrice.toFloatOrNull()
        val quantity = inputPrdQuantity.toIntOrNull()

        if (price == null || quantity == null || inputPrdCategory == 0) {
            Log.e("mytag", "error: Invalid input (price, quantity, or category)")
            return
        }
        val product = Product(
            category = inputPrdCategory,
            title = inputPrdTitle,
//            price = inputPrdPrice.toFloatOrNull() ?: 0.0f,
//            quantity = inputPrdQuantity.toIntOrNull() ?: 0
            price = price,
            quantity = quantity
        )
        viewModelScope.launch(Dispatchers.IO) {
            try {
                productDao.insertProduct(product)
                val updatedProducts = productDao.getAllProducts()
                ListofProducts.clear()
                ListofProducts.addAll(updatedProducts)
            } catch (e: Exception) {
                Log.e("mytag", "Error inserting product", e)
            }
        }
        clearFields()
    }


    fun deleteProduct() {
        selectedProduct?.let { product ->
            viewModelScope.launch(Dispatchers.IO) {
                productDao.deleteProduct(product)
                val updatedUsers = productDao.getAllProducts()
                ListofProducts.clear()
                ListofProducts.addAll(updatedUsers)
            }
            clearFields()
        }
    }


    fun clearFields(){
        inputPrdCategory = 0
        inputPrdTitle = ""
        inputPrdPrice = ""
        inputPrdQuantity = ""
    }

}