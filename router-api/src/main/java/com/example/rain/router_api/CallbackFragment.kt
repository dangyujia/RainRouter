package com.example.rain.router_api

import android.app.Fragment
import android.content.Intent

/**
 * fragment 回调
 */
class CallbackFragment : Fragment() {

    var callback: Callback? = null

    fun setCallback(call: Callback?): CallbackFragment {
        callback = call
        return this
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (callback != null) {
            callback?.onActivityResult(requestCode, resultCode, data!!)
        }
    }

}