package com.qw73.itfactory.task.Common

import com.qw73.itfactory.task.Network.APIService
import com.qw73.itfactory.task.Network.Retrofit

object Common {
    private const val BASE_URL = "https://api.npoint.io/"
    val getAPIService: APIService
        get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)
}