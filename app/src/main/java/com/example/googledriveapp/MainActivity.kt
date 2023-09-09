package com.example.googledriveapp

import android.R.id.message
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.gson.GsonBuilder


class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_SIGN_IN = 100
    //val driveServiceHelper: DriveS
    val TAG = "lifeCyActivity_"
    var textViewShow: TextView ?= null
    var address: String = ""
    var data : adress?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"MainActivity"+ ": onCreate")

        initComponent()
        initListener()
        initObserver()
    }

    private fun initComponent() {
        textViewShow = findViewById<TextView>(R.id.tvShow)
        address = "Mirpur DHOS"
    }

    private fun initListener() {
        textViewShow?.setOnClickListener {
            Log.d(TAG,"onClick"+ "${GsonBuilder().create().toJson(data)}")


           /* startActivity(Intent(this@MainActivity, ActivitySecond::class.java).apply {
                putExtra(CONS_ADDRESS, "${GsonBuilder().create().toJson(data)}")
            })*/

            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, "mrsaykatm4@gmail.com")
            email.putExtra(Intent.EXTRA_SUBJECT, "Hi")
            email.putExtra(Intent.EXTRA_TEXT, message)

            startActivity(Intent.createChooser(email, "Choose an Email client:"))

        }
    }

    private fun initObserver() {
        data = adress(roadNo = null,area = "Mirpur DHOS")
        Log.i(TAG,"$data")

    }

    override fun onStart() {
        super.onStart()

        val account: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(applicationContext)

        if (account == null) {
            signIn()
        } else{

        }

        Log.d(TAG,"MainActivity"+ ": onStart")
    }

    private fun signIn() {
        //TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"MainActivity"+ ": onResume $data")
        data?.roadNo = 9
        Log.i(TAG,"$data")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"MainActivity"+ ": onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"MainActivity"+ ": onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"MainActivity"+ ": onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"MainActivity"+ ": onDestroy")
    }
}