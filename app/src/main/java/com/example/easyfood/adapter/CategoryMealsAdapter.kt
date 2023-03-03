package com.example.easyfood.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easyfood.databinding.ActivityCategoryMealsBinding
import com.example.easyfood.databinding.MealItemBinding
import com.example.easyfood.pojo.MealsByCategory

class CategoryMealsAdapter(): RecyclerView.Adapter<CategoryMealsAdapter.CategoryMealsViewHolder>() {

    lateinit var onItemClick: ((MealsByCategory) -> Unit)
    var mealsList = ArrayList<MealsByCategory>()

    fun setMealsList(mealsList:List<MealsByCategory>) {
        this.mealsList = mealsList as ArrayList<MealsByCategory>
        notifyDataSetChanged()
    }

    inner class CategoryMealsViewHolder(val binding: MealItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMealsViewHolder {
       return CategoryMealsViewHolder(MealItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    override fun onBindViewHolder(holder: CategoryMealsViewHolder, position: Int) {
        Glide.with(holder.itemView).load(mealsList[position].strMealThumb).into(holder.binding.imgMeal)
        holder.binding.tvMealName.text = mealsList[position].strMeal

        holder.itemView.setOnClickListener {
           onItemClick.invoke(mealsList[position])
        }
    }

}