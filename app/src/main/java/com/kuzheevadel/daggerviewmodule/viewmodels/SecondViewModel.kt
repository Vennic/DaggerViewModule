package com.kuzheevadel.daggerviewmodule.viewmodels

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.kuzheevadel.daggerviewmodule.Network
import javax.inject.Inject

class SecondViewModel @Inject constructor(val net: Network): ViewModel() {

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModelTest", "SecondOnCleared $this: Neteork - $net")
    }
}