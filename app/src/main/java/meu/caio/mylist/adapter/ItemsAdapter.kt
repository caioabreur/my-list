package meu.caio.mylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import meu.caio.mylist.listeners.ItemListener
import meu.caio.mylist.model.ItemModel
import com.example.mylist.viewholder.ItemViewHolder
import meu.caio.mylist.databinding.RowItemBinding

class ItemsAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private var itemList: List<ItemModel> = listOf()
    private lateinit var listener: ItemListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    fun updateItems(list: List<ItemModel>) {
        itemList = list
        notifyDataSetChanged()
    }

    fun attachListener(itemListener: ItemListener) {
        listener = itemListener
    }
}