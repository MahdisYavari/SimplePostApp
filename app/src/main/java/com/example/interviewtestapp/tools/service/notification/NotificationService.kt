package com.example.interviewtestapp.tools.service.notification

interface NotificationService {
    fun showInformation(text: String)
    fun showError(text: String)
    fun showLongInformation(text: String)
}