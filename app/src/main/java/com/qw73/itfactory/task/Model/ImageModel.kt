package com.qw73.itfactory.task.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImageModel {
    @SerializedName("1x")
    @Expose
    var x1: String? = null

    @SerializedName("2x")
    @Expose
    var x2: String? = null

    @SerializedName("3x")
    @Expose
    var x3: String? = null
}