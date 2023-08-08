package com.example.interviewtestapp.tools.network.api

import retrofit2.http.GET

//define retrofit api
interface FlickrApi {

    @GET("flickr.interestingness.getList")
    suspend fun getData()
}