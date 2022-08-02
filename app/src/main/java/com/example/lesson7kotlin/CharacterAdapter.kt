package com.example.lesson7kotlin


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson7kotlin.databinding.ItemCharacterBinding

class CharacterAdapter(private val data: ArrayList<Character>, private val onClick: (pos:Int)->Unit) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount(): Int = data.size

    inner class CharacterViewHolder(private var binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.life.text = character.life.toString()
            binding.name.text = character.name.toString()
            binding.charImage.setBackgroundResource(getCharacter(adapterPosition).image)
            
        }
    }

}