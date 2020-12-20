package com.tamnn.trackme.dependency

import com.tamnn.trackme.mvp.Screen

interface DataCache {

    fun putScreen(key: String, screen: Screen)

    fun popScreen(key: String): Screen?
}