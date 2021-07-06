package com.example.rain.router_api

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable

/**
 * 跳转中转站
 */
class Postcard(private val activityName: String) {

    private lateinit var bundle: Bundle

    init {
        bundle = Bundle()
    }


    fun withString(key: String, value: String): Postcard {
        bundle.putString(key, value)
        return this
    }

    fun withInt(key: String, value: Int): Postcard {
        bundle.putInt(key, value)
        return this
    }

    fun withFloat(key: String, value: Float): Postcard {
        bundle.putFloat(key, value)
        return this
    }

    fun withLong(key: String, value: Long): Postcard {
        bundle.putLong(key, value)
        return this
    }

    fun withParcelable(key: String, value: Parcelable): Postcard {
        bundle.putParcelable(key, value)
        return this
    }

    fun with(b: Bundle?): Postcard {
        if (b != null) {
            bundle = b
        }
        return this
    }

    fun navigation(context: Context) {
        val intent = Intent()
        intent.component = ComponentName(context.packageName, activityName)
        intent.putExtras(bundle)
        context.startActivity(intent)
    }


    fun navigation(context: Activity, requestCode: Int) {
        val intent = Intent()
        intent.component = ComponentName(context.packageName, activityName)
        intent.putExtras(bundle)
        context.startActivityForResult(intent, requestCode)
    }

    fun navigation(context: Context, requestCode: Int, callback: Callback) {
        if (context is Activity) {
            val intent = Intent()
            intent.component = ComponentName(context.packageName, activityName)
            intent.putExtras(bundle)
            getFragment(context)
                .setCallback(callback)
                .startActivityForResult(intent, requestCode)
        }
    }

    fun navigation(context: Context, callback: Callback) {
        navigation(context, 0, callback)
    }

    private val TAG = "com.example.rain.router_api.Postcard"

    private fun getFragment(activity: Activity): CallbackFragment {
        val fragmentManager = activity.fragmentManager
        var fragment = fragmentManager.findFragmentByTag(TAG) as CallbackFragment
        if (fragment == null) {
            fragment = CallbackFragment()
            fragmentManager.beginTransaction().add(fragment, TAG)
                .commitAllowingStateLoss()
            fragmentManager.executePendingTransactions()
        }
        return fragment
    }

}