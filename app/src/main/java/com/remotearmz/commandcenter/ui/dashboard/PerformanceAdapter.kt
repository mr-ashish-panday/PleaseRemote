package com.remotearmz.commandcenter.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.remotearmz.commandcenter.R
import com.remotearmz.commandcenter.databinding.ItemPerformanceBinding

class PerformanceAdapter : ListAdapter<PerformanceItem, PerformanceAdapter.PerformanceViewHolder>(PerformanceDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerformanceViewHolder {
        val binding = ItemPerformanceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PerformanceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PerformanceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PerformanceViewHolder(private val binding: ItemPerformanceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PerformanceItem) {
            binding.apply {
                performanceTitle.text = item.title
                performanceProgress.progress = item.progress
            }
        }
    }

    private class PerformanceDiffCallback : DiffUtil.ItemCallback<PerformanceItem>() {
        override fun areItemsTheSame(oldItem: PerformanceItem, newItem: PerformanceItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: PerformanceItem, newItem: PerformanceItem): Boolean {
            return oldItem == newItem
        }
    }
}

data class PerformanceItem(
    val title: String,
    val progress: Int
)
