package com.example.googledriveapp.view

import android.R.id.message
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.googledriveapp.R
import com.example.googledriveapp.model.adress
import com.example.googledriveapp.services.RunningService
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_SIGN_IN = 100

    // val driveServiceHelper: DriveS
    val TAG = "lifeCyActivity_"
    var textViewShow: TextView ? = null
    private lateinit var buttonStart: Button
    private lateinit var buttonStop: Button
    var address: String = ""
    var data: adress? = null
    var callBackClick: ((String) -> Unit)? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity" + ": onCreate")

        initComponent()
        initService()
        initListener()
        initObserver()

    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun initService() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 0)
    }

    private fun initComponent() {
        textViewShow = findViewById<TextView>(R.id.tvShow)
        buttonStart = findViewById<Button>(R.id.btnStart)
        buttonStop = findViewById<Button>(R.id.btnStop)
        address = "Mirpur DHOS"
    }

    private fun initListener() {
        textViewShow?.setOnClickListener {
//            Log.d(TAG,"onClick"+ "${GsonBuilder().create().toJson(data)}")
//
//            callBackClick?.invoke(address)
//            startActivity(Intent(this@MainActivity, ActivitySecond::class.java).apply {
//                putExtra(CONS_ADDRESS, "${GsonBuilder().create().toJson(data)}")
//            })

            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, "mrsaykatm4@gmail.com")
            email.putExtra(Intent.EXTRA_SUBJECT, "Hi")
            email.putExtra(Intent.EXTRA_TEXT, message)

            startActivity(Intent.createChooser(email, "Choose an Email client:"))
        }

        // Foreground service active button
        buttonStart.setOnClickListener{
            Intent(applicationContext, RunningService::class.java).also {
                it.action = RunningService.Actions.START.toString()
                startService(it)
            }
        }

        // Foreground service destroy button
        buttonStop.setOnClickListener{
            Intent(applicationContext, RunningService::class.java).also {
                it.action = RunningService.Actions.STOP.toString()
                startService(it)
            }
        }
    }

    private fun initObserver() {
        data = adress(roadNo = null, area = "Mirpur DHOS")
        Log.i(TAG, "$data")
    }

    override fun onStart() {
        super.onStart()

        val account: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(applicationContext)

        if (account == null) {
            signIn()
        } else {
        }

        Log.d(TAG, "MainActivity" + ": onStart")
    }

    private fun signIn() {
        // TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity" + ": onResume $data")
        data?.roadNo = 9
        Log.i(TAG, "$data")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity" + ": onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity" + ": onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity" + ": onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity" + ": onDestroy")
    }
}
