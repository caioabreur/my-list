package meu.caio.mylist.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import meu.caio.mylist.model.ItemModel

@Dao
interface ItemDAO {

    @Insert
    fun insertItem(item: ItemModel): Long

    @Update
    fun updateItem(item: ItemModel): Int

    @Delete
    fun deleteItem(item: ItemModel): Int

    @Query("SELECT * FROM Items WHERE id = :id")
    fun getAnItem(id: Int): ItemModel

    @Query("SELECT * FROM Items")
    fun getAllItems(): List<ItemModel>

    @Query("DELETE FROM Items")
    fun deleteAllItems()
}