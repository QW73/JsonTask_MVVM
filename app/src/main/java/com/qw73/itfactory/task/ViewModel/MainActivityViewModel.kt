package com.qw73.itfactory.task.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.qw73.itfactory.task.Model.SectionModel
import com.qw73.itfactory.task.Model.SectionsListModel
import com.qw73.itfactory.task.Repositories.MainRepo

class MainActivityViewModel : ViewModel() {
    private var mainRepo: MainRepo
    val getAllSectionsList: LiveData<SectionsListModel<SectionModel>>
        get() = mainRepo.getSelectionLiveData

    init {
        mainRepo = MainRepo()
    }

}