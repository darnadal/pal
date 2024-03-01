package com.example.pal

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val items: List<ABCItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        // Déterminez ici le type de vue en fonction des données
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // Créez une nouvelle vue en fonction du viewType et retournez le ViewHolder correspondant
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Liez les données à la vue en fonction du type de holder
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
