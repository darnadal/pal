package com.example.pal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val items = MutableLiveData<List<ABCItem>>()

    fun fetchItems() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.fetchItems()
                if (response.isSuccessful && response.body() != null) {
                    val filteredItems = response.body()!!.abcCollection.values.filter { it.abcParentKey == "0" || it.abcParentKey == "null" }
                    items.postValue(filteredItems)
                } else {
                    // Gérer l'erreur
                }
            } catch (e: Exception) {
                // Gérer l'exception
            }
        }
    }
}