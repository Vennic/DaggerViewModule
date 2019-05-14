package com.kuzheevadel.daggerviewmodule.viewmodels

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.kuzheevadel.daggerviewmodule.Database
import javax.inject.Inject

class MainViewModel @Inject constructor(val database: Database): ViewModel() {

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModelTest", "Main onCleared: Database - $database")
    }
}