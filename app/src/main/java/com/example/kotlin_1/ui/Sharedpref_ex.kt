package com.example.kotlin_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.kotlin_1.R
import com.example.kotlin_1.utils.PrfManager
import com.example.kotlin_1.utils.constants.KEY_AGE_NAME
import com.example.kotlin_1.utils.constants.KEY_FIRST_NAME
import com.example.kotlin_1.utils.constants.KEY_Last_NAME
import com.example.kotlin_1.utils.toast

class Sharedpref_ex : AppCompatActivity() {
     lateinit var edt_firstname : EditText
    lateinit var edt_lastname : EditText
    lateinit var edt_age : EditText
    lateinit var btn_save : Button
    lateinit var btn_load : Button

   private lateinit var prfmanager : PrfManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpref_ex)
        findid()
        prfmanager = PrfManager(applicationContext)
        
        btn_save.setOnClickListener {
            prfmanager.savePrefString(KEY_FIRST_NAME,edt_firstname.text.toString())
            prfmanager.savePrefString(KEY_Last_NAME,edt_lastname.text.toString())
            prfmanager.saveprefInt(KEY_AGE_NAME,edt_age.text.toString().toInt())

            toast("data saved successfully")
        }

        btn_load.setOnClickListener {
            edt_firstname.setText(prfmanager.getPrefString(KEY_FIRST_NAME))
            edt_lastname.setText(prfmanager.getPrefString(KEY_Last_NAME))
            edt_age.setText(prfmanager.getPrefInt(KEY_AGE_NAME).toString())
        }
        



    }




    private fun findid() {
        edt_firstname = findViewById(R.id.edt_firstname)
        edt_lastname=findViewById(R.id.edt_lasttname)
        edt_age=findViewById(R.id.edt_age)
        btn_save=findViewById(R.id.btn_save)
        btn_load=findViewById(R.id.btn_load)

    }
}