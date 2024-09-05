package com.example.mylist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import meu.caio.mylist.model.ItemModel
import meu.caio.mylist.repository.ItemsListRepository

class AddNewItemViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ItemsListRepository(application.applicationContext)


    fun insertItem(item: ItemModel) {
        repository.insertItem(item)
    }
}