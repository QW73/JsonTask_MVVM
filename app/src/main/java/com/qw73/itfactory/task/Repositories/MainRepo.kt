package com.qw73.itfactory.task.Repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.qw73.itfactory.task.Common.Common
import com.qw73.itfactory.task.Model.SectionModel
import com.qw73.itfactory.task.Model.SectionsListModel
import com.qw73.itfactory.task.Network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo {
    private val apiService: APIService

    companion object {
        private const val TAG = "MainRepo"
    }

    init {
        apiService = Common.getAPIService
    }

    val getSelectionLiveData: MutableLiveData<SectionsListModel<SectionModel>>
        get() {
            val data: MutableLiveData<SectionsListModel<SectionModel>> =
                MutableLiveData<SectionsListModel<SectionModel>>()
            apiService.getAllSectionsList()
                .enqueue(object : Callback<SectionsListModel<SectionModel>> {
                    override fun onResponse(
                        call: Call<SectionsListModel<SectionModel>>,
                        response: Response<SectionsListModel<SectionModel>>,
                    ) {
                        Log.e(TAG, "onResponse: " + response.code())
                        if (response.isSuccessful) {
                            data.value = response.body()
                        } else {
                            data.value = null
                        }
                    }

                    override fun onFailure(
                        call: Call<SectionsListModel<SectionModel>>,
                        t: Throwable,
                    ) {
                        Log.e(TAG, "onResponse: " + t.message)
                        data.value = null
                    }
                })
            return data
        }
}