package com.tom.enhanceit.ui.list

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tom.enhanceit.databinding.ItemViewBinding

class LaunchViewHolder(view: ItemViewBinding) : RecyclerView.ViewHolder(view.root) {
    val name: TextView = view.name
    val date: TextView = view.date
    val image: ImageView = view.imageLaunch
    val successImage: ImageView = view.successImage
}