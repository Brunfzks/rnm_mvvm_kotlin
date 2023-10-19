package com.example.rnm_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.rnm_mvvm.R
import com.example.rnm_mvvm.databinding.ItemListBinding
import com.example.rnm_mvvm.model.Character

class CharacterAdapter(private var items: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    var onItemClick: ((Character) -> Unit)? = null

    fun setItemClick(action: (Character) -> Unit) {
        this.onItemClick = action
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.MyViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.MyViewHolder, position: Int) {
        val item = items[position]

        holder.itemBinding.textName.text = item.name
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MyViewHolder(@NonNull val itemBinding: ItemListBinding) : RecyclerView.ViewHolder(itemBinding.root) {


        init {

        }


    }

}