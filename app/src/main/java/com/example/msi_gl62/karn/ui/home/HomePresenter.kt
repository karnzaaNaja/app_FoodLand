package com.example.msi_gl62.karn.ui.home

import com.example.msi_gl62.karn.InterActor
import com.example.msi_gl62.karn.callapi.Request
import com.example.msi_gl62.karn.model.ListFood
import com.example.msi_gl62.myapplication.ui.home.HomeContact

class HomePresenter (val view: HomeContact.View) : HomeContact.Presenter, Request.ResponseListFood {

    private val actData: InterActor.ActData = Request()

    override fun callListFoodApi(key: String?) {
     actData.callListFoodApi(this)
    }

    override fun <T> onSuccess(t: T) {
        view.onCallSuccess(coWorkPopular = (t as ListFood).results)
    }
}

