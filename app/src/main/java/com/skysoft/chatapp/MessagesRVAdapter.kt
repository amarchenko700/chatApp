package com.skysoft.chatapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skysoft.chatapp.databinding.ItemMessageBinding

class MessagesRVAdapter : RecyclerView.Adapter<MessagesRVAdapter.ViewHolder>() {

    var arrayMessage = mutableListOf<Message>()

    inner class ViewHolder(private val binding: ItemMessageBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(message: Message){
            binding.tvUserId.text = message.senderId
            binding.tvMessage.text = message.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMessageBinding = ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = arrayMessage.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = arrayMessage[position]
        holder.bind(message)
    }
}