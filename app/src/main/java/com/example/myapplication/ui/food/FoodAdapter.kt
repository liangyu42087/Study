package com.example.myapplication.ui.food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.db.model.Food
import kotlinx.android.synthetic.main.food_list_item_layout.view.*


class FoodAdapter : ListAdapter<Food, FoodAdapter.FoodViewHolder>(FoodDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        return FoodViewHolder(inflator.inflate(R.layout.food_list_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = getItem(position)
        food?.let {
            holder.foodNameTv.text = food.foodName
            holder.foodPriceTv.text = food.price.toString()
        }
    }

    inner class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodNameTv = view.food_name_item_tv
        val foodPriceTv = view.food_price_item_tv
    }

    class FoodDiff : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.foodName == newItem.foodName
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.foodName == newItem.foodName
        }
    }
}