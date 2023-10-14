package com.example.rnm_mvvm.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.rnm_mvvm.databinding.ItemListBinding
import com.example.rnm_mvvm.model.Character
import com.example.rnm_mvvm.model.RnmReturn

class RnmRetunAdapter(private var items: RnmReturn) :
    RecyclerView.Adapter<RnmRetunAdapter.MyViewHolder>() {

    var onItemClick: ((Character) -> Unit)? = null

    fun setItemClick(action: (Character) -> Unit) {
        this.onItemClick = action
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RnmRetunAdapter.MyViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RnmRetunAdapter.MyViewHolder, position: Int) {
        val item = items.results[position]

        holder.itemBinding.textName.text = item.name
        holder.itemBinding.imageView.setImageURI(Uri.parse(item.image))
    }

    override fun getItemCount(): Int {
        return items.results.size
    }

    inner class MyViewHolder(@NonNull val itemBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        init {

        }


    }

}