package com.mti.playground

import android.app.Application
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class MyApp:Application() {


    override fun onCreate() {
        super.onCreate()
    }

   companion object{
       private var retrofitInstance: Retrofit? = null
       fun getRetrofitInstance() : Retrofit?{
           if (retrofitInstance == null) {
               var client =  OkHttpClient.Builder()
                   .connectTimeout(100000, TimeUnit.SECONDS)
                   .readTimeout(100000, TimeUnit.SECONDS)

                   .build();
               retrofitInstance = Retrofit.Builder()
                   .baseUrl("https://www.boredapi.com/api/")
                   .client(client)
                   .addConverterFactory(ScalarsConverterFactory.create())
                   .addConverterFactory(GsonConverterFactory.create()) //.client(client)
                   .build()
           }
           return retrofitInstance
       }
   }
}