package com.qw73.itfactory.task.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SectionsListModel<T> {
    @SerializedName("sections")
    @Expose
    var sections: ArrayList<SectionModel> = arrayListOf()
}