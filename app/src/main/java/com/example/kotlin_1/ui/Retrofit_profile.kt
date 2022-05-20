package com.example.kotlin_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_1.R
import kotlinx.android.synthetic.main.activity_retrofit_profile.*

class Retrofit_profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_profile)

        view_symbol.text = getIntent().getStringExtra("symbol")
        view_baseasset.text = getIntent().getStringExtra("baseAsset")
        view_quoteasset.text = getIntent().getStringExtra("quoteAsset")
        view_volume.text = getIntent().getStringExtra("volume")
        view_openprice.text = getIntent().getStringExtra("openprice")
        view_highprice.text = getIntent().getStringExtra("highPrice")
        view_lowprice.text = getIntent().getStringExtra("lowPrice")
        view_lastprice.text = getIntent().getStringExtra("lastPrice")
    }
}