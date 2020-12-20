package com.tamnn.trackme.feature.main

import com.tamnn.trackme.dependency.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent  {

    val presenter: MainContract.Presenter

    fun inject(activity: MainActivity)
}