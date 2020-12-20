package com.tamnn.trackme.mvp


interface PresenterCache {

    fun generatePresenterId(): Int

    fun <P : Presenter<*, *>> getPresenter(id: Int): P?

    fun setPresenter(id: Int, presenter: Presenter<*, *>?)
}