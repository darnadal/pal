package com.example.pal

import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("qTest.json")
    suspend fun fetchItems(): Response<ABCollection>
}