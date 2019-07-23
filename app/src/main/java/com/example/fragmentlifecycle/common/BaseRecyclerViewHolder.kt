package com.example.stickersampleapp.common

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerViewHolder<T>(val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {
    open fun bind(data: T) {}
    open fun bind(data: T, position: Int) {}
}