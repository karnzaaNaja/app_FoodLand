package com.example.msi_gl62.karn.ui.home.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.msi_gl62.karn.extension.load
import com.example.msi_gl62.karn.model.FoodModel
import kotlinx.android.synthetic.main.item_theme_food_home.view.*

class ListFoodHealth(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(food: FoodModel) {

        itemView.apply {
            imageFood.load(food.image)
            foodName.text = food.food_name
        }


    }
}