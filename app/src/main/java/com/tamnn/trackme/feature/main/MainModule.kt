package com.tamnn.trackme.feature.main

import android.app.Activity
import android.app.Application

import com.tamnn.trackme.domain.SchedulerFactory
import com.tamnn.trackme.domain.UseCaseFactory

import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
class MainModule(private val _Activity: Activity) {

    @Provides
    internal fun providePresenter(application: Lazy<Application>,
                                  useCaseFactory: Lazy<UseCaseFactory>,
                                  schedulerFactory: Lazy<SchedulerFactory>): MainContract.Presenter = MainPresenter(application, useCaseFactory, schedulerFactory)
}