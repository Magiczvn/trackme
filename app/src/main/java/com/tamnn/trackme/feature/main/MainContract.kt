package com.tamnn.trackme.feature.main

interface MainContract {

    interface View {


    }

    interface Presenter:com.tamnn.trackme.mvp.Presenter<View, MainViewState> {

    }
}