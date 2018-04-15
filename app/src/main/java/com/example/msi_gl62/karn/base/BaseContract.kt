package com.example.msi_gl62.karn.base

open class BaseContract {

    interface View {
        fun showProgressDialog()
    }

    interface Presenter<V : View> {
        fun onViewCreate()
        fun onViewDestroy()
        fun onViewStart()
        fun onViewStop()
    }
}