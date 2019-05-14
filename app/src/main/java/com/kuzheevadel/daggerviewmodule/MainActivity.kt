package com.kuzheevadel.daggerviewmodule

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kuzheevadel.daggerviewmodule.di.App
import com.kuzheevadel.daggerviewmodule.di.DemoViewModelFactory
import com.kuzheevadel.daggerviewmodule.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: DemoViewModelFactory

    @Inject
    lateinit var mainView: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).getApppComponent().inject(this)

        mainView = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        button_first.setOnClickListener {
            mainView.database.settIndex(1994)
            mainView.database.load()
            mainView.database.self()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("ViewModelTest", "Main on Stop")
    }
}
