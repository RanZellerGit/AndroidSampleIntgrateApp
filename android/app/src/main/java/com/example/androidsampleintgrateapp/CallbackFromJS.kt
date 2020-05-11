package com.example.androidsampleintgrateapp

import android.widget.Toast
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class CallbackFromJS(val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext){

    override fun getName(): String = "CallbackFromJS"

    @ReactMethod
    fun callbackAns(message: String?) {
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}