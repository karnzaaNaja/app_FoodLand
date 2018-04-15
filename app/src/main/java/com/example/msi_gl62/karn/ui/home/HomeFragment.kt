package com.example.msi_gl62.myapplication.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msi_gl62.karn.R
import com.example.msi_gl62.karn.model.FoodModel
import com.example.msi_gl62.karn.ui.home.HomePresenter
import com.example.msi_gl62.karn.ui.home.adapter.AdapterListFood
import com.example.msi_gl62.karn.ui.home.adapter.AdapterListFoodHealth
import com.example.msi_gl62.karn.ui.home.adapter.AdapterListFoodPopular
import kotlinx.android.synthetic.main.activity_home.*

class HomeFragment : Fragment(), HomeContact.View {

    private lateinit var presenter: HomeContact.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.activity_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = HomePresenter(this)
        presenter.callListFoodApi()
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onCallSuccess(coWorkPopular: List<FoodModel>?) {
        val fd: AdapterListFood by lazy { AdapterListFood(listOf()) }
        listFood?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        listFood?.isNestedScrollingEnabled = false
        listFood?.adapter = fd
        coWorkPopular?.let { fd.setItem(it) }

        val foodPop: AdapterListFoodPopular by lazy { AdapterListFoodPopular(listOf()) }
        listFoodPop?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        listFoodPop?.isNestedScrollingEnabled = false
        listFoodPop?.adapter = foodPop
        coWorkPopular?.let { foodPop.setItem(it) }

        val foodHealth: AdapterListFoodHealth by lazy { AdapterListFoodHealth (listOf()) }
        listFoodHealth?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        listFoodHealth?.isNestedScrollingEnabled = false
        listFoodHealth?.adapter = foodHealth
        coWorkPopular?.let { foodHealth.setItem(it) }


    }


}
