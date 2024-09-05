package meu.caio.mylist.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import meu.caio.mylist.repository.ItemDAO
import meu.caio.mylist.model.ItemModel

@Database(entities = [ItemModel::class], version = 1)
abstract class ItemDataBase : RoomDatabase() {

    abstract fun itemDao(): ItemDAO

    companion object {
        private lateinit var INSTANCE: ItemDataBase

        fun getInstance(context: Context): ItemDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(ItemDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, ItemDataBase::class.java, "itemdb")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }

}