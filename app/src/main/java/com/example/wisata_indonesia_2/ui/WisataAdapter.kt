package com.example.wisata_indonesia_2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisata_indonesia_2.R
import com.example.wisata_indonesia_2.model.Wisata

class WisataAdapter(
    private var items: List<Wisata>,
    private val itemClickListener: (Wisata) -> Unit
) : RecyclerView.Adapter<WisataAdapter.WisataViewHolder>() {

    inner class WisataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.tvName)
        val locationTextView: TextView = view.findViewById(R.id.tvLocation)
        val descriptionTextView: TextView = view.findViewById(R.id.tvDescription)

        init {
            view.setOnClickListener {
                val currentItem = items[adapterPosition]
                itemClickListener(currentItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        return WisataViewHolder(view)
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        val wisataItem = items[position]
        holder.nameTextView.text = wisataItem.name
        holder.locationTextView.text = wisataItem.location
        holder.descriptionTextView.text = wisataItem.description
    }

    override fun getItemCount(): Int = items.size

    fun updateList(newItems: List<Wisata>) {
        items = newItems
        notifyDataSetChanged()
    }
}
