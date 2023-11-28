package com.example.examenfinal.Models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetroFitHelper {
    val baseURL = "https://api.mockfly.dev/mocks/7f79f18f-eb77-443f-8f29-3030d3bd5ca7/"

    fun getRetroFitHelper(): Retrofit{
    return Retrofit.Builder().baseUrl(baseURL).addConverterFactory(
        GsonConverterFactory.create()).build()

   }
}