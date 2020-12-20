package com.tamnn.trackme.mvp

interface PresenterFactory<out P : Presenter<*, *>> {

    fun createPresenter(): P
}