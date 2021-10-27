package com.example.headupsql

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface APIInterface {

    @Headers("Content-Type: application/json")
    @GET("/celebrities/")
    fun getCelebrityDetails(): Call<List<CelebrityDetails.Datum>>

}