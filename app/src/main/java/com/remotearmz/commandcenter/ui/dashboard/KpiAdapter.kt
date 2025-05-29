package com.remotearmz.commandcenter.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.remotearmz.commandcenter.R
import com.remotearmz.commandcenter.databinding.ItemKpiCardBinding

class KpiAdapter : ListAdapter<KpiItem, KpiAdapter.KpiViewHolder>(KpiDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KpiViewHolder {
        val binding = ItemKpiCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return KpiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KpiViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class KpiViewHolder(private val binding: ItemKpiCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: KpiItem) {
            binding.apply {
                kpiTitle.text = item.title
                kpiValue.text = item.value
                kpiIcon.setImageResource(item.iconRes)
            }
        }
    }

    private class KpiDiffCallback : DiffUtil.ItemCallback<KpiItem>() {
        override fun areItemsTheSame(oldItem: KpiItem, newItem: KpiItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: KpiItem, newItem: KpiItem): Boolean {
            return oldItem == newItem
        }
    }
}

data class KpiItem(
    val title: String,
    val value: String,
    val iconRes: Int
)
