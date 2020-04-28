package com.raywenderlich.android.gobuy.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.gobuy.R
import com.raywenderlich.android.gobuy.databinding.GroceryListItemBinding
import com.raywenderlich.android.gobuy.model.GroceryItem


class GroceryAdapter(val items: ArrayList<GroceryItem>, val context: Context,
                     val itemEditListener: (position: Int) -> Unit,
                     val itemDeleteListener: (position: Int) -> Unit) : RecyclerView.Adapter<GroceryListViewHolder>() {
    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryListViewHolder {
        return GroceryListViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.grocery_list_item,
                parent, false))
    }

    override fun onBindViewHolder(holder: GroceryListViewHolder, position: Int) {
        val item = items[position]
        val description = item.amount.toString() + "x: " + item.itemName
        holder.bind(items[position])
        holder.binding.buttonEdit.setOnClickListener {
            itemEditListener(position)
        }
        holder.binding.buttonDelete.setOnClickListener {
            itemDeleteListener(position)
        }

    }
}

class GroceryListViewHolder(val binding: GroceryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: GroceryItem) {
        binding.apply {
            // itemName = "{item.amount}x: ${item.itemName}"
            // price = item.price.toString()
        }
    }

}

