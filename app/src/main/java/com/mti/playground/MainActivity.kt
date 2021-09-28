package com.mti.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mti.playground.databinding.ActivityMainBinding
import com.mti.playground.dto.BoredResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private val apiService = MyApp.getRetrofitInstance()?.create(
        ApiEndpoint::class.java
    )
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            apiService?.getFact()?.enqueue( object : Callback<BoredResponse>{
                override fun onResponse(
                    call: Call<BoredResponse>,
                    response: Response<BoredResponse>
                ) {
                    if (response.isSuccessful)
                    binding.textView.setText(response.body()?.activity)
                }

                override fun onFailure(call: Call<BoredResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "error!", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}