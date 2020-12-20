package com.tamnn.trackme.mvp

interface ViewStateFactory<out S : ViewState> {

    fun createViewState(): S

    fun getViewStateTag(): String
}