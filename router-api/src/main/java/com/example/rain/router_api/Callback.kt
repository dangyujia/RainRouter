package com.example.rain.router_api

import android.content.Intent

interface Callback {

    /**
     * activity 回调
     */
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)

}