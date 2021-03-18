package com.example.spacexapi.services

import com.example.spacexapi.models.RocketData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXService {

    @GET("rockets/")
    fun getSpaceXList() : Call<List<RocketData>>
}