package com.example.storagemanager.Data.Product

import android.app.Application
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

    var inputPrdCategory by mutableStateOf("")
        private set

    var inputPrdTitle by mutableStateOf("")
        private set

    var inputPrdPrice by mutableStateOf(0.0f)
        private set

    var inputPrdQuantity by mutableStateOf(0)
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


    fun onPrdCategoryChange(newTitle: String) {
        inputPrdCategory = newTitle
    }

    fun onPrdTitleChange(newTitle: String) {
        inputPrdTitle = newTitle
    }

    fun onPrdPriceChange(newPrice: Float) {
        inputPrdPrice = newPrice
    }

    fun onPrdQuantityChange(newQuantity: Int) {
        inputPrdQuantity = newQuantity
    }

    fun selectProduct(product: Product) {
        selectedProduct = product
        inputPrdCategory = product.category
        inputPrdTitle = product.title
        inputPrdPrice = product.price
        inputPrdQuantity = product.quantity
    }


    fun addUser() {
        val product = Product(
            category = inputPrdCategory,
            title = inputPrdTitle,
            price = inputPrdPrice,
            quantity = inputPrdQuantity
        )
        viewModelScope.launch(Dispatchers.IO) {
            productDao.insertProduct(product)
            val updatedProducts = productDao.getAllProducts()
            ListofProducts.clear()
            ListofProducts.addAll(updatedProducts)
        }
        clearFields()
    }


    fun deleteUser() {
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
        inputPrdCategory = ""
        inputPrdTitle = ""
        inputPrdPrice = 0.0f
        inputPrdQuantity = 0
    }

}