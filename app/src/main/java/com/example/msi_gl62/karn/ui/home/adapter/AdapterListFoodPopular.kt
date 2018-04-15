package com.example.msi_gl62.karn.ui.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.msi_gl62.karn.R
import com.example.msi_gl62.karn.model.FoodModel
import com.example.msi_gl62.karn.ui.home.holder.ListFoodPopularHolder

class AdapterListFoodPopular (private var coWork: List<FoodModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<FoodModel>) {
        coWork = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ListFoodPopularHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    override fun getItemCount(): Int = coWork.size

    override fun getItemViewType(position: Int): Int = R.layout.item_theme_food_home

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = (holder as ListFoodPopularHolder).onBind(coWork[position])



}