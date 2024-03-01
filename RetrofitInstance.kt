package com.example.pal

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object RetrofitInstance {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://loqual.pro/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: APIService by lazy {
            retrofit.create(APIService::class.java)
        }
    }