package com.qw73.itfactory.task.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.qw73.itfactory.task.Model.ItemModel
import com.qw73.itfactory.task.databinding.LayoutSelectionCardsBinding


class ItemListAdapter(
    private val items: List<ItemModel>,
) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    private lateinit var cardsBinding: LayoutSelectionCardsBinding
    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        cardsBinding =
            LayoutSelectionCardsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(cardsBinding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        val url = currentItem.image!!.x2
        holder.cardBind(currentItem, url!!)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(cardsBinding: LayoutSelectionCardsBinding) :
        RecyclerView.ViewHolder(cardsBinding.root) {

        fun cardBind(currentItem: ItemModel, picUrl: String) {
            cardsBinding.cardDescription = currentItem.title
            Glide.with(cardsBinding.cardId.context).load(picUrl).into(cardsBinding.cardIcon)
        }

        init {
            cardsBinding.cardId.setOnClickListener {
                listener.onItemClick(cardsBinding.cardId)
            }
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(itemView: View?)
    }
}

