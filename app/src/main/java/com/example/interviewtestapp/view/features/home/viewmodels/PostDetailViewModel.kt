package com.example.interviewtestapp.view.features.home.viewmodels

import com.example.interviewtestapp.R
import com.example.interviewtestapp.intent.HomeIntent
import com.example.interviewtestapp.model.repository.PostRepository
import com.example.interviewtestapp.tools.base.viewmodel.VisibleViewModel
import com.example.interviewtestapp.tools.service.notification.NotificationService
import com.example.interviewtestapp.view.viewstate.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val postRepository: PostRepository,
    override val notificationService: NotificationService) :
    VisibleViewModel<HomeIntent, HomeState>() {

    override fun handleIntent(it: HomeIntent) {
        super.handleIntent(it)
        when (it) {
            is HomeIntent.InitPostDetail -> {
                initView(it.postId)
            }
            is HomeIntent.ChangeLikeCount -> {
                changeLikeCount(/*it.postId*/)
            }
            else -> {}
        }
    }

    private fun changeLikeCount(/*postId: String?*/) {
      //  _mviState.value = HomeState.InitLikeStatePost(postId)
    }

    private fun initView(postId: String?) {
        notificationService.showInformation(activityContext.getString(R.string.post_detail))
        val postItem = postRepository.getPostDetailById(postId)
            _mviState.value = HomeState.InitDetailPost(postItem)
    }
}