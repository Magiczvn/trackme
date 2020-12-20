package com.tamnn.trackme.feature.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.tamnn.trackme.R
import com.tamnn.trackme.TrackMeApplication
import com.tamnn.trackme.common.RxBus
import com.tamnn.trackme.dependency.DataCache
import com.tamnn.trackme.dependency.HasComponent
import com.tamnn.trackme.domain.SchedulerFactory
import com.tamnn.trackme.mvp.BaseMvpActivity
import dagger.Lazy
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : BaseMvpActivity<MainContract.View, MainContract.Presenter, MainViewState, MainScreen>(),
    HasComponent<MainComponent>, MainContract.View {

    companion object {

        fun instance(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

    @Inject
    lateinit var _SchedulerFactory: SchedulerFactory
    @Inject
    lateinit var _Bus: RxBus
    @Inject
    lateinit var _DataCache: Lazy<DataCache>

    override fun onCreatePresenter(context: Context) = component.presenter

    override fun onCreateViewState(context: Context): MainViewState {
        return MainViewState()
    }

    override val viewStateTag: String get() = MainViewState::class.java.name

    override val layoutResource get() = R.layout.activity_main

    private var _Disposable: CompositeDisposable? = null

    override val component by lazy {
        TrackMeApplication.get(this).component.plus(MainModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)

        if (intent.action == Intent.ACTION_MAIN && !isTaskRoot) {
            finish()
        }


        _Disposable = CompositeDisposable()
    }

    override fun onDestroy() {
        _Disposable?.dispose()
        super.onDestroy()
    }
}