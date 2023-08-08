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
class PostListViewModel @Inject constructor(
    private val postRepository: PostRepository,
    override val notificationService: NotificationService) :
    VisibleViewModel<HomeIntent, HomeState>() {

    override fun handleIntent(it: HomeIntent) {
        super.handleIntent(it)
        when(it){
            HomeIntent.InitData -> initView()
        }
    }

    private fun initView() {
        notificationService.showInformation(activityContext.getString(R.string.home))
        launchWithState {
            //init list
            val list = postRepository.getPostList()
            _mviState.value = HomeState.InitData(list)
        }
    }
}