package com.qw73.itfactory.task

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.qw73.itfactory.task.Adapter.SectionListAdapter
import com.qw73.itfactory.task.ViewModel.MainActivityViewModel
import com.qw73.itfactory.task.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val rv = binding.recyclerView

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mainActivityViewModel!!.getAllSectionsList.observe(this) { sectionsModels ->
            Log.e("MainActivity", "SelectionList: " + sectionsModels.sections.size)
            if (sectionsModels != null) {
                rv.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity,
                        LinearLayoutManager.VERTICAL, false)
                    adapter = SectionListAdapter(sectionsModels.sections,context)
                }
            }
        }
    }
}