package meu.caio.mylist.repository

import android.content.ContentValues
import android.content.Context
import meu.caio.mylist.constants.DbConstants
import meu.caio.mylist.model.ItemModel
import meu.caio.mylist.repository.ItemDataBase

class ItemsListRepository(context: Context) {

    private val itemsDB = ItemDataBase.getInstance(context).itemDao()

    fun insertItem(item: ItemModel): Boolean {
        return itemsDB.insertItem(item) > 0
    }

    fun updateItem(item: ItemModel): Boolean {
        return itemsDB.updateItem(item) > 0
    }

    fun deleteItem(id: Int): Boolean {
        val item = getAnItem(id)
        return itemsDB.deleteItem(item) > 0
    }

    fun getAnItem(id: Int): ItemModel {
        return itemsDB.getAnItem(id)
    }

    fun getAllItems(): List<ItemModel> {
        return itemsDB.getAllItems()
    }

    fun deleteAllItems(){
        itemsDB.deleteAllItems()
    }
}