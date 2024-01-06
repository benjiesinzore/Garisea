package com.garisea.datasets.local.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.garisea.datasets.databinding.TipsItemLayoutBinding
import com.garisea.datasets.local.models.ItemTips

class ItemTipsAdapter (private val items: List<ItemTips>)  : RecyclerView.Adapter<ItemTipsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TipsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]
        holder.title.text = item.name
        holder.description.text = item.description
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(binding: TipsItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        val title: TextView = binding.tipsTitle
        val description: TextView = binding.tipsDescription
    }
}