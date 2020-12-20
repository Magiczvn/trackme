package com.tamnn.trackme.mvp

interface CacheFactory {

    val presenterCache: PresenterCache

    val viewStateCache: ViewStateCache
}