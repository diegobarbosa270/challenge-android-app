package com.dob.desafioapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dob.desafioapp.databinding.ListItemCardBinding
import com.dob.desafioapp.domain.entity.Card

class AdapterCards(private val cardSelected: (Card) -> Unit) :
    ListAdapter<Card, AdapterCards.CardViewHolder>(AdapterCardsCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            ListItemCardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), cardSelected
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CardViewHolder(
        private val binding: ListItemCardBinding,
        private val cardSelected: (Card) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Card) {
            binding.title.text = item.name
            val description = "${item.type} / ${item.rarity}"
            binding.description.text = description
            Glide.with(itemView.context)
                .load(item.img)
                .into(binding.imageViewCard)
            binding.cardId.setOnClickListener {
                cardSelected.invoke(item)
            }
        }
    }

    class AdapterCardsCallback : DiffUtil.ItemCallback<Card>() {
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem == newItem
        }

    }

}