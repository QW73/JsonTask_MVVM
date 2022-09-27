package com.qw73.itfactory.task.Network

import com.qw73.itfactory.task.Model.SectionModel
import com.qw73.itfactory.task.Model.SectionsListModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("05b0db32009fa4e548a3")
    fun getAllSectionsList(): Call<SectionsListModel<SectionModel>>

}