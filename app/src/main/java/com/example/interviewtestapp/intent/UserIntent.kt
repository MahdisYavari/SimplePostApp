package com.example.interviewtestapp.intent

import com.example.interviewtestapp.model.User
import com.example.interviewtestapp.tools.base.mvi.IntentBase

sealed class UserIntent: IntentBase {
    class CreateUser(val user: User, val finallyAction: () -> Unit) : UserIntent()
}