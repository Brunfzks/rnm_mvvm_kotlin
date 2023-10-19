package com.example.rnm_mvvm.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rnm_mvvm.R
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
        holder.itemBinding.textLast.text = item.location?.name
        holder.itemBinding.textStatus.text = "${item.status} - ${item.species}"
        holder.itemBinding.statusAlive.setImageResource(if(item.status == "Alive") R.drawable.status_alive_dot else R.drawable.status_death_dot);
        Glide.with(holder.itemView).load(item.image).into(holder.itemBinding.imageView);

    }

    override fun getItemCount(): Int {
        return items.results.size
    }

    interface  OnListSelected {
        fun onSelected(character: Character)
    }


    inner class MyViewHolder(@NonNull val itemBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        init {

            onItemClick?.let {
                itemBinding.root.setOnClickListener {
                    it(items.results[adapterPosition])
                }
            }


        }
    }

}