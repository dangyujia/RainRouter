package com.example.rain.router_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class RouterPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "插件开始执行......"
        project.android.registerTransform(new RouterTransformApi(project))
    }
}