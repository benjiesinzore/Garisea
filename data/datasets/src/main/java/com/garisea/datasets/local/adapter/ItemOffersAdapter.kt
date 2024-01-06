package com.garisea.datasets.local.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.garisea.datasets.databinding.OffersItemLayoutBinding
import com.garisea.datasets.local.models.ItemOffers

class ItemOffersAdapter (private val items: List<ItemOffers>)  : RecyclerView.Adapter<ItemOffersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = OffersItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]
        holder.title.text = item.name
        holder.valid.text = item.valid
        holder.description.text = item.description
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(binding: OffersItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        val title: TextView = binding.offersTitle
        val valid: TextView = binding.offersValid
        val description: TextView = binding.offersDescription
    }
}