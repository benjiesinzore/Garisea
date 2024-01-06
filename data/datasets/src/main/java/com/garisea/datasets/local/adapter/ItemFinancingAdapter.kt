package com.garisea.datasets.local.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.garisea.datasets.databinding.FinancingItemLayoutBinding
import com.garisea.datasets.local.models.ItemFinancing

class ItemFinancingAdapter(private val items: List<ItemFinancing>)  : RecyclerView.Adapter<ItemFinancingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FinancingItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    class ViewHolder(private val binding: FinancingItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        val title: TextView = binding.financingTitle
        val description: TextView = binding.financingDescription
    }

}