package com.icterguru.icterguru

/**
 * Created by mhossa200 on 4/9/2018.
 */

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherForcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forcast)

        var forcastListView = findViewById<ListView>(R.id.listViewForcast)
        var listOfCities = listOf<String>("Philadelphia", "Havertown", "Center City", "University City", "Dallas", "New York", "Las Vegas", "Reno", "Tuscaloosa", "Dhaka", "Philadelphia", "Havertown", "Center City", "University City", "Dallas", "New York", "Las Vegas", "Reno", "Tuscaloosa", "Dhaka", "Philadelphia", "Havertown", "Center City", "University City", "Dallas", "New York", "Las Vegas", "Reno", "Tuscaloosa", "Dhaka")
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfCities)

        var retriever = WeatherRetriever()

        val callback = object : Callback<Weather>{
            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println("It failed ...")
            }


            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println("We have got a response....")
                println(response?.body()?.query?.results?.channel?.title)
                title = response?.body()?.query?.results?.channel?.title

/*
                for (forcastDay in response!!.body()!!){
                    println("High: ${forcastDay.high} \t Low: ${forcastDay.low} ")
                }
*/
            }

        }

        retriever.getForcast(callback)

    }
}
