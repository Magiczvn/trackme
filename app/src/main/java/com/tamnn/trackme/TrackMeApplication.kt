package com.tamnn.trackme

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.tamnn.trackme.common.RxBus
import com.tamnn.trackme.dependency.AppComponent
import com.tamnn.trackme.dependency.AppModule
import com.tamnn.trackme.dependency.DaggerAppComponent
import com.tamnn.trackme.dependency.HasComponent


open class TrackMeApplication : Application(), HasComponent<AppComponent>  {

    private lateinit var _AppComponent: AppComponent

    private var _ActivityLifecycle: ActivityLifecycle? = null

    companion object {
        fun get(context: Context): TrackMeApplication = context.applicationContext as TrackMeApplication
    }

    override fun onCreate() {
        super.onCreate()
        _AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }



    override fun onTerminate() {
        super.onTerminate()
    }

    override val component: AppComponent
        get() = _AppComponent


    inner class ActivityLifecycle(bus: RxBus) : ActivityLifecycleCallbacks {

        private val _Bus = bus


        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

        }

        override fun onActivityStarted(activity: Activity) {


        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {


        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

        }

        override fun onActivityDestroyed(activity: Activity) {

        }
    }

}