package com.kuzheevadel.daggerviewmodule

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kuzheevadel.daggerviewmodule.di.App
import com.kuzheevadel.daggerviewmodule.di.DemoViewModelFactory
import com.kuzheevadel.daggerviewmodule.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.second_layout.*
import javax.inject.Inject

class SecondActivity: AppCompatActivity() {

    @Inject
    lateinit var factory: DemoViewModelFactory

    @Inject
    lateinit var second: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        (application as App).getApppComponent().inject(this)

        second = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        button_second.setOnClickListener {
            second.database.load()
            second.database.self()}
    }
}