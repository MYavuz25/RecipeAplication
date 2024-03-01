package com.example.recipeapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapplication.databinding.RecyclerviewElementBinding
import com.squareup.picasso.Picasso

class recyclerAdapter(private val recipeList:ArrayList<Recipe_model>, private val listener:Listener):RecyclerView.Adapter<recyclerAdapter.RecipeHolder>() {

    interface Listener{
        fun onRecipeclick(recipeModel: Recipe_model)
    }
    class RecipeHolder (val binding: RecyclerviewElementBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(recipeModel: Recipe_model,listener: Listener){
            Picasso.get().load("https://images.immediate.co.uk/production/volatile/sites/30/2008/01/Christmas-pie-2ed9223.jpg?quality=90&webp=true&resize=375,341").into(binding.recipeImage)
            binding.recipeAuthorName.text=recipeModel.Author
            binding.recipeName.text=recipeModel.Name
            itemView.setOnClickListener{
                listener.onRecipeclick(recipeModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val binding=RecyclerviewElementBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecipeHolder(binding)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.bind(recipeList[position],listener)
    }
}