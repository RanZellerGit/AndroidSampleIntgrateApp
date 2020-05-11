package com.example.androidsampleintgrateapp

import android.app.Application
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.ReactRootView
import com.facebook.react.shell.MainReactPackage
import com.facebook.soloader.SoLoader

class RNApplication : Application() , ReactApplication {

    companion object {
        lateinit var app : RNApplication
    }
    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this,false)
        ReactRootView(this).startReactApplication(reactNativeHost.reactInstanceManager, "MyAndroidReactNativeApp", null)
        app = this
    }
    private val mReactNativeHost: ReactNativeHost = object : ReactNativeHost(this) {
        override fun getUseDeveloperSupport(): Boolean {
            return BuildConfig.DEBUG
        }

        override fun getPackages(): List<ReactPackage> {
            return listOf(MainReactPackage(), MyPackage())
        }

        override fun getJSMainModuleName(): String {
            return "index"
        }
    }
    override fun getReactNativeHost(): ReactNativeHost {
        return mReactNativeHost
    }
}