package com.tamnn.trackme.feature.main

import android.app.Application
import com.tamnn.trackme.domain.SchedulerFactory
import com.tamnn.trackme.domain.UseCaseFactory
import com.tamnn.trackme.mvp.BasePresenter

import dagger.Lazy
import io.reactivex.Scheduler

class MainPresenter(private val _Application: Lazy<Application>,
                    private val _UseCaseFactory: Lazy<UseCaseFactory>,
                    private val _SchedulerFactory: Lazy<SchedulerFactory>)
    : BasePresenter<MainContract.View, MainViewState>(), MainContract.Presenter {

    //region Private
    private val _WorkerScheduler: Scheduler by lazy {
        _SchedulerFactory.get().single()
    }


    override fun onCreate(viewState: MainViewState) {
        super.onCreate(viewState)

    }

    override fun onAttachView(view: MainContract.View) {
        super.onAttachView(view)


    }

    override fun onDestroy() {
        super.onDestroy()
    }


}

