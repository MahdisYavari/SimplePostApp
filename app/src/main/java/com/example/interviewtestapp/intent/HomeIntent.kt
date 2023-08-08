package com.example.interviewtestapp.intent

import com.example.interviewtestapp.tools.base.mvi.IntentBase

sealed class HomeIntent: IntentBase {
    object InitData: HomeIntent()
    class InitPostDetail(val postId: String?): HomeIntent()
    object ChangeLikeCount: HomeIntent()
}