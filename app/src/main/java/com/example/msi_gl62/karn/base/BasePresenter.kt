package com.example.msi_gl62.karn.base

abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {

    override fun onViewCreate() {}

    override fun onViewStart() {}

    override fun onViewDestroy() {}

    override fun onViewStop() {}
}