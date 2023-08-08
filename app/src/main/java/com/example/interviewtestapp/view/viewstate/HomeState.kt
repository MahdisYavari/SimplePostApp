package com.example.interviewtestapp.view.viewstate

import com.example.interviewtestapp.model.Post
import com.example.interviewtestapp.tools.base.mvi.ViewStateBase

sealed class HomeState: ViewStateBase{
   class InitData(val list: List<Post>): HomeState()
   class InitDetailPost(val post: Post?): HomeState()
   class InitLikeStatePost(val post: Post): HomeState()
}