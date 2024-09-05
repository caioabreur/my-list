package meu.caio.mylist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
class ItemModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int = 0

    @ColumnInfo
    var name: String = ""

    @ColumnInfo
    var quantity: Int = 0
}