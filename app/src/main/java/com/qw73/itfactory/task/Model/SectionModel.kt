package com.qw73.itfactory.task.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SectionModel {

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("items")
    @Expose
    var items: ArrayList<ItemModel> = arrayListOf()

    @SerializedName("header")
    @Expose
    var header: String? = null

    @SerializedName("itemsTotal")
    @Expose
    var itemsTotal: Int? = null

    @SerializedName("itemsToShow")
    @Expose
    var itemsToShow: Int? = null


}

