package com.kuzheevadel.daggerviewmodule.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kuzheevadel.daggerviewmodule.viewmodels.MainViewModel
import com.kuzheevadel.daggerviewmodule.viewmodels.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class Module {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModule(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    abstract fun secondViewModel(secondViewModel: SecondViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DemoViewModelFactory): ViewModelProvider.Factory
}
