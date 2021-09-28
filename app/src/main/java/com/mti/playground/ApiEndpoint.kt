package com.mti.playground

import com.mti.playground.dto.BoredResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("activity")
    fun getFact() : Call<BoredResponse>
}