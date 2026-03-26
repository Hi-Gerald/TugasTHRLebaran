package com.geraldeberhard.tugasthrlebaran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geraldeberhard.tugasthrlebaran.databinding.ItemAnnouncementBinding

class AnnouncementAdapter(
    private val onClick: (Announcement) -> Unit
) : ListAdapter<Announcement, AnnouncementAdapter.ViewHolder>(DiffCallback) {

    inner class ViewHolder(
        private val binding: ItemAnnouncementBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(announcement: Announcement) {
            binding.tvTitle.text = announcement.title
            binding.tvDate.text = announcement.date
            binding.tvCategory.text = announcement.category
            binding.root.setOnClickListener { onClick(announcement) }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Announcement>() {
        override fun areItemsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Announcement, newItem: Announcement): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAnnouncementBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}