package com.qw73.itfactory.task.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemModel {

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("image")
    @Expose
    var image: ImageModel? = ImageModel()

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("aspectRatio")
    @Expose
    var aspectRatio: Int? = null

    @SerializedName("loopAnimation")
    @Expose
    var loopAnimation: Boolean? = null
}