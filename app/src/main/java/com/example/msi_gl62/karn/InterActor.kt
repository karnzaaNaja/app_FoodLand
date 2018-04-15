package com.example.msi_gl62.karn

import com.example.msi_gl62.karn.callapi.Request


class InterActor {

    interface ActData {
        fun callListFoodApi(callback: Request.ResponseListFood)
    }
}