package com.example.msi_gl62.myapplication.ui.home

import com.example.msi_gl62.karn.model.FoodModel

interface HomeContact {

    interface Presenter {
        fun callListFoodApi(key: String? = null)
    }
    interface View {
        fun onCallSuccess(coWorkPopular: List<FoodModel>?)
    }
}