package com.icterguru.icterguru

/**
 * Created by mhossa200 on 4/9/2018.
 */


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by mhossa200 on 4/9/2018.
 */
interface WeatherAPI{
    //    @GET("bins/uo8uj")
    @GET("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
//    fun getForcast(): Call<List<Forcast>>
    fun getForcast() : Call <Weather>
}

class Weather(val query: WeatherQuery)
class WeatherQuery(val results: WeatherResults)
class WeatherResults(val channel: WeatherChannel)
class WeatherChannel(val title: String)

class Forcast(val high:String, val low:String)

class WeatherRetriever {
    val service: WeatherAPI

    init {
//       val retrofit = Retrofit.Builder().baseUrl("https://api.myjson.com").addConverterFactory(GsonConverterFactory.create()).build()
        val retrofit = Retrofit.Builder().baseUrl("https://query.yahooapis.com/v1/public/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherAPI::class.java)
    }

    //    fun getForcast(callback: Callback<List<Forcast>>){
    fun getForcast(callback: Callback<Weather>){
        val call = service.getForcast()
        call.enqueue(callback)
    }

}