package com.example.kotlin_1.firebase

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.kotlin_1.Home_activity
import com.example.kotlin_1.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


const val channelID = "notificaton_channel"
const val channelName = "com.example.kotlin_1.firebase"



class MyFirebaseMessagingService  : FirebaseMessagingService(){

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        if(remoteMessage.notification != null){
            generateToken(remoteMessage.notification!!.title!!,remoteMessage.notification!!.body!!)
        }
    }


    fun getRemoteview(tittle: String,message: String) : RemoteViews{
        val remoteViews = RemoteViews("com.example.kotlin_1.firebase",R.layout.notification_design)

       remoteViews.setTextViewText(R.id.notification_tittle,tittle)
        remoteViews.setTextViewText(R.id.notification_desc,message)
        remoteViews.setImageViewResource(R.id.notification_img,R.drawable.img)

        return remoteViews
    }



    fun generateToken(tittle : String , message : String){
        val intent = Intent(this,Home_activity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingintent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)

        var builder : NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelID)
            .setSmallIcon(R.drawable.img)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingintent)

        builder = builder.setContent(getRemoteview(tittle,message))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val notificationChannel = NotificationChannel(channelID, channelName,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)

        }

        notificationManager.notify(0,builder.build())

    }


}