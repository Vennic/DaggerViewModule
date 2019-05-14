package com.kuzheevadel.daggerviewmodule.di

import android.app.Application
import android.content.Context
import com.kuzheevadel.daggerviewmodule.Database
import com.kuzheevadel.daggerviewmodule.MainActivity
import com.kuzheevadel.daggerviewmodule.Network
import com.kuzheevadel.daggerviewmodule.SecondActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


class App: Application() {
    private val appComponent by lazy {DaggerAppComponent.builder()
        .application(this)
        .appModule(AppModule(this))
        .build()}

    fun getApppComponent(): AppComponent {
        return appComponent
    }
}

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun appModule(appModeule: AppModule): Builder

        fun build(): AppComponent
    }

    fun inject(main: MainActivity)
    fun inject(second: SecondActivity)
}

@Module(includes = [com.kuzheevadel.daggerviewmodule.di.Module::class])
class AppModule(val context: Context) {

    @Singleton
    @Provides
    fun provCintext() = context

    @Singleton
    @Provides
    fun database(context: Context): Database {
        return Database(context)
    }

    @Singleton
    @Provides
    fun provideNetwork() = Network()
}