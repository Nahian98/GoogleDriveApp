package com.example.googledriveapp.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.googledriveapp.R
import com.example.googledriveapp.utils.CONS_ADDRESS

class ActivitySecond : AppCompatActivity() {
    val TAG = "lifeCyActivity_Second"
    var address = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")
        getExtra()
        initComponent()
    }

    private fun getExtra() {
        address = intent.getStringExtra(CONS_ADDRESS) ?: ""
    }

    private fun initComponent() {
        if (!TextUtils.isEmpty(address)) {
            findViewById<TextView>(R.id.tvShow).text = address
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
