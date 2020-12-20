package com.tamnn.trackme.dependency

import android.app.Application
import android.telephony.TelephonyManager


import com.tamnn.trackme.common.RxBus
import com.tamnn.trackme.domain.SchedulerFactory
import com.tamnn.trackme.domain.UseCaseFactory
import dagger.Component
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    val application: Application
    val bus: RxBus

    val useCaseFactory: UseCaseFactory
    val schedulerFactory: SchedulerFactory
    val dataCache: DataCache

    @get:Type("activity_stack")
    val activityStack: MutableList<String>

    @get:Type("current_activity_stack")
    val currentActivityStack: MutableList<String>
}
