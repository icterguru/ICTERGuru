package com.icterguru.icterguru

/**
 * Created by mhossa200 on 4/9/2018.
 */

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        var getForcastButton = findViewById<Button>(R.id.getForcastButton)
        getForcastButton.setOnClickListener(){
            var moveIntent = Intent(this, WeatherForcastActivity::class.java)
            startActivity(moveIntent)

        }

    }
}

