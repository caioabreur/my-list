package com.example.mylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import meu.caio.mylist.model.ItemModel
import meu.caio.mylist.repository.ItemsListRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ItemsListRepository(application.applicationContext)

    private val listItems = MutableLiveData<List<ItemModel>>()
    val items: LiveData<List<ItemModel>> = listItems

    fun getAllItems() {
        listItems.value = repository.getAllItems()
    }

    fun deleteItem(id: Int) {
        repository.deleteItem(id)
    }

    fun deleteAllItems() {
        repository.deleteAllItems()
    }
}