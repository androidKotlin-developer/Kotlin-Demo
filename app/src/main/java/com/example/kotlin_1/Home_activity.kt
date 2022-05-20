package com.example.kotlin_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin_1.tablayout.TabLayout_prac
import com.example.kotlin_1.ui.*
import kotlinx.android.synthetic.main.activity_home.*

class Home_activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_homerecycerview.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

        btn_sharedpref.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Sharedpref_ex::class.java)
            startActivity(intent)
        })

        btn_retrofit.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,Retrofir_prac::class.java)
            startActivity(intent)
        })


        btn_notification.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,PushNotification::class.java)
            startActivity(intent)
        })

        btn_tablayout.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, TabLayout_prac::class.java)
            startActivity(intent)
        })

        btn_webview.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, WebView_Prac::class.java)
            startActivity(intent)
        })

        btn_call_sms_email.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Call_Sms_Email::class.java)
            startActivity(intent)
        })
    }
}