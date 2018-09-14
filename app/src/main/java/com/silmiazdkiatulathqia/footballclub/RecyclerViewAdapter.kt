package com.silmiazdkiatulathqia.footballclub

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(private val items: List<Item>, private val listener: (Item) -> Unit) :
        RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val ui = AnkoContext.create(parent.context, parent)
        val fcItem = FCItem()
        val view = fcItem.createView(ui)

        return ViewHolder(view, fcItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}