package com.example.interviewtestapp.view.viewstate

import com.example.interviewtestapp.tools.base.mvi.ViewStateBase

sealed class UserState: ViewStateBase{
   object IsAvailableUser: UserState()
}