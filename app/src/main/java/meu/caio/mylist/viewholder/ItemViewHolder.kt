package com.example.mylist.viewholder

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import meu.caio.mylist.listeners.ItemListener
import meu.caio.mylist.model.ItemModel
import meu.caio.mylist.databinding.RowItemBinding

class ItemViewHolder(private val binding: RowItemBinding, private val listener: ItemListener) : ViewHolder(binding.root) {

    fun bind(item: ItemModel) {
        val textName = binding.textItemName
        val quantity = binding.textItemQuantity

        textName.text = item.name
        quantity.text = item.quantity.toString()

        binding.imageRemove.setOnClickListener{
            listener.onClick(item.id)
        }
    }
}