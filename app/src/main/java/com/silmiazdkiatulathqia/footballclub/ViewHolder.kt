package com.silmiazdkiatulathqia.footballclub

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide

class ViewHolder(val view: View, private val fcItem: FCItem) : RecyclerView.ViewHolder(view) {

    fun bindItem(item: Item, listener: (Item) -> Unit) {
        fcItem.textView.text = item.name
        Glide.with(itemView.context).load(item.image).into(fcItem.imageView)

        itemView.setOnClickListener {
            listener(item)
        }
    }
}
