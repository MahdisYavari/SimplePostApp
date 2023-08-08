package com.example.interviewtestapp.tools.network.api

import retrofit2.http.GET

//define retrofit api
interface UserApi {

    @GET
    suspend fun getData()
}