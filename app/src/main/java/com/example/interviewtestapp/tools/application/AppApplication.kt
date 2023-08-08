package com.example.interviewtestapp.tools.application

import android.app.Application
import com.example.interviewtestapp.tools.network.NetworkHandler
import com.example.interviewtestapp.tools.service.notification.NotificationServiceImp
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@HiltAndroidApp
class AppApplication : Application() {

    override fun onCreate() {
        try {
            super.onCreate()
            context = this
            NetworkHandler.context = this
            NotificationServiceImp.androidApplication = this

        } catch (e: Exception) {
        }
    }

    companion object {
        lateinit var context: AppApplication
    }
}