package com.example.msi_gl62.karn.callapi

import com.example.msi_gl62.karn.InterActor
import com.example.msi_gl62.karn.model.ListFood
import com.example.msi_gl62.karn.network.BaseRetrofit
import com.example.msi_gl62.karn.network.BaseUrl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class Request : InterActor.ActData {

    interface ResponseListFood  {
        fun <T> onSuccess(t: T)
    }

    override fun callListFoodApi(callback: ResponseListFood) {
        val baseService by lazy { BaseRetrofit.createRx(BaseUrl.baseUrl) }
        baseService?.ListFood()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableObserver<Response<ListFood>>() {
                    override fun onComplete() {}
                    override fun onNext(t: Response<ListFood>) {
                        t.body()?.let { callback.onSuccess(it) }
                    }
                    override fun onError(e: Throwable) {}
                })
    }


}