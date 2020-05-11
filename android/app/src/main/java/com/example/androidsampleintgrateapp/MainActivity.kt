package com.example.androidsampleintgrateapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.facebook.react.bridge.WritableNativeArray
import com.facebook.soloader.SoLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val OVERLAY_PERMISSION_REQ_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
                )
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE)
            }
        }

        button.setOnClickListener{
            val reactContext = RNApplication.app.reactNativeHost.reactInstanceManager.currentReactContext

            val catalystInstance = reactContext!!.catalystInstance
            val params = WritableNativeArray()
            params.pushString("Message to show using nameOfJsMethod")
            params.pushInt(5)
            catalystInstance.callFunction("JavaScriptVisibleToJava", "nameOfJsMethod", params)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) { // SYSTEM_ALERT_WINDOW permission not granted
                }
            }
        }
    }
}
