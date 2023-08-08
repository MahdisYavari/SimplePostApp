package com.example.interviewtestapp.model.repository

import com.example.interviewtestapp.tools.base.BaseRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
   // private val userApi: UserApi
) : BaseRepository() {

    suspend fun getUser(){
//        return userApi.getData()
    }
}
