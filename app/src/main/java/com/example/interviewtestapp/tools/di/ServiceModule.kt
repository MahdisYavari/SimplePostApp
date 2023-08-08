package com.example.interviewtestapp.tools.di

import com.example.interviewtestapp.tools.service.notification.NotificationService
import com.example.interviewtestapp.tools.service.notification.NotificationServiceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun bindNotificationService(): NotificationService {
        return NotificationServiceImp()
    }
}