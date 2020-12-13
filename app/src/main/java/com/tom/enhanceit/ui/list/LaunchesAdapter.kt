package com.tom.enhanceit.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tom.enhanceit.R
import com.tom.enhanceit.databinding.ItemViewBinding
import com.tom.enhanceit.model.Launch
import com.tom.enhanceit.utils.loadImage

class LaunchesAdapter(private val onClickListener: (launchId: Long, view: View) -> Unit) :
    RecyclerView.Adapter<LaunchViewHolder>() {

    var list: List<Launch> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val launch = list[position]
        val successImage = ContextCompat.getDrawable(
            holder.successImage.context,
            if (launch.success == true) R.drawable.success else R.drawable.failure
        )
        holder.image.loadImage(launch.imageUrl ?: "")
        holder.name.text = launch.name
        holder.date.text = launch.date_local.toString()
        holder.successImage.setImageDrawable(successImage)
        holder.itemView.setOnClickListener {

        }
    }

}