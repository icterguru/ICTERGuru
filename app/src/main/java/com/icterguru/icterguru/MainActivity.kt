package com.icterguru.icterguru

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var workHistory = findViewById<Button>(R.id.workHistoryButton)
        workHistory.setOnClickListener {
            println("Hey, you hit the workHistory button ")

            var moveToWorkHistory = Intent(getApplicationContext(), WorkHistoryActivity::class.java)

            startActivity(moveToWorkHistory)
            println("You made it! ")


            var callButton = findViewById<Button>(R.id.callMHButton)
            callButton.setOnClickListener() {
                println("Call MH")
                var phoneUri = Uri.parse("tel:2157765846")
                var callIntent = Intent(Intent.ACTION_DIAL, phoneUri)
                startActivity(callIntent)
            }

            var emailButton = findViewById<Button>(R.id.emailMHButton)
            emailButton.setOnClickListener() {
                println("Email MH ")
                var emailIntent = Intent(Intent.ACTION_SEND)
                emailIntent.setType("plain/text")
                emailIntent.putExtra(Intent.EXTRA_EMAIL, "mokter@gmail.com")
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Test email from CollResume")
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello, MH, I really enjoyed your resume.... ")
                startActivity(emailIntent)
            }


            var weatherForcastButton = findViewById<Button>(R.id.weatherForcastButton)
            weatherForcastButton.setOnClickListener(){
            println("Hey, you hit the Weather Forcast button ")
            var moveToWeatherForcast = Intent(getApplicationContext(), WeatherActivity::class.java)
            startActivity(moveToWeatherForcast)
            println("You made it! ")
            }

        }

    }
}

