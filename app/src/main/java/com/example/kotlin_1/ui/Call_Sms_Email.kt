package com.example.kotlin_1.ui


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.text.TextUtils
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlin_1.R
import kotlinx.android.synthetic.main.activity_call_sms_email.*


class Call_Sms_Email : AppCompatActivity() {

    val permissionRequest = 101
    lateinit var email: String
    lateinit var subject: String
    lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_sms_email)

        btn_email.setOnClickListener {
            getdata()
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Select email"))
        }


        btn_sms.setOnClickListener {

            val permissionCheck =
                ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                myMessage()
            } else {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.SEND_SMS),
                    permissionRequest
                )
            }

        }
    }

    fun myMessage() {
        val myNumber: String = editTextSubject.text.toString().trim()
        val myMsg: String = editTextMessage.text.toString().trim()
        if (myNumber == "" || myMsg == "") {
            Toast.makeText(this, "Field cannot be empty", Toast.LENGTH_SHORT).show()
        } else {
            if (TextUtils.isDigitsOnly(myNumber)) {
                val smsManager: SmsManager = SmsManager.getDefault()
                smsManager.sendTextMessage("+91 " + myNumber, null, myMsg, null, null)
                Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show()
                editTextSubject.text.clear()
                editTextMessage.text.clear()
            } else {
                Toast.makeText(this, "Please enter the correct number", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

     fun getdata(){
         email = editTextMail.text.toString()
         subject = editTextSubject.text.toString()
         message = editTextMessage.text.toString()
    }
}