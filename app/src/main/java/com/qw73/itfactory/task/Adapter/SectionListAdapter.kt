package com.qw73.itfactory.task.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qw73.itfactory.task.Model.SectionModel
import com.qw73.itfactory.task.databinding.LayoutSelectionBinding


class SectionListAdapter(
    private val sections: List<SectionModel>, private val context: Context,
) :
    RecyclerView.Adapter<SectionListAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    private lateinit var sectionBinding: LayoutSelectionBinding
    private var selectedItems: MutableList<View> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        sectionBinding =
            LayoutSelectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(sectionBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSection = sections[position]
        holder.bind(currentSection)
        val cardsRV = sectionBinding.recyclerViewForCards
        val adapter = ItemListAdapter(currentSection.items)
        val itemLayoutManager = LinearLayoutManager(
            cardsRV.context, LinearLayoutManager.HORIZONTAL, false)

        cardsRV.apply {
            layoutManager = itemLayoutManager
            cardsRV.adapter = adapter
            adapter.setOnItemClickListener(object : ItemListAdapter.OnItemClickListener {
                override fun onItemClick(itemView: View?) {
                    if (selectedItems.size < 6) {
                        if (itemView?.isSelected == true) {
                            unselectItem(itemView)
                        } else {
                            selectItem(itemView!!)
                        }
                    } else {
                        clearSelection(selectedItems)
                    }
                }
            })
            setRecycledViewPool(viewPool)
        }
    }

    fun clearSelection(selectedItems: MutableList<View>) {
        for (i in 0 until selectedItems.size) {
            selectedItems[i].isSelected = false
        }
        selectedItems.clear()
        notifyDataSetChanged()
        Toast.makeText(context,
            "More than 6 articles were selected!",
            Toast.LENGTH_SHORT).show()
    }

    fun selectItem(v: View) {
        v.isSelected = true
        selectedItems.add(v)
    }

    fun unselectItem(v: View) {
        v.isSelected = false
        selectedItems.remove(v)
    }

    override fun getItemCount(): Int {
        return sections.size
    }

    inner class ViewHolder(sectionBinding: LayoutSelectionBinding) :
        RecyclerView.ViewHolder(sectionBinding.root) {
        fun bind(currentSection: SectionModel) {
            sectionBinding.title = currentSection.header
        }
    }
}