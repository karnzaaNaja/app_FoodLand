package com.example.msi_gl62.karn.network

import com.example.msi_gl62.karn.model.ListFood
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface BaseService {

    @GET("list_data_food")
    fun ListFood(): Observable<Response<ListFood>>

}