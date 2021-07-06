package com.example.rain.router_api

import java.util.*

class ARouter {
    private val routeMap: Map<String, String> = HashMap()
    private var loaded = false

    companion object {
        private val instance: ARouter = ARouter()
        fun getInstance(): ARouter {
            if (!instance.loaded) instance.init()
            return instance
        }
    }

    fun init() {
        if (loaded) return
        RouteMap().loadInto(routeMap)
        loaded = true
    }

    fun getMap(): Map<String, String> {
        return routeMap
    }

    fun build(path: String): Postcard {
        val component = routeMap[path] ?: throw RuntimeException("could not find route with $path")
        return Postcard(component)
    }
}