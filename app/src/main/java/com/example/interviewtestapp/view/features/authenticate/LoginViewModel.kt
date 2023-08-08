package com.example.interviewtestapp.view.features.authenticate

import androidx.lifecycle.MutableLiveData
import com.example.interviewtestapp.intent.UserIntent
import com.example.interviewtestapp.model.repository.UserRepository
import com.example.interviewtestapp.tools.base.viewmodel.VisibleViewModel
import com.example.interviewtestapp.tools.event.Event
import com.example.interviewtestapp.tools.extensions.asImmutable
import com.example.interviewtestapp.tools.service.notification.NotificationService
import com.example.interviewtestapp.view.viewstate.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    override val notificationService: NotificationService
) : VisibleViewModel<UserIntent,UserState>() {

    private val _isLogin = MutableLiveData<Event<Boolean>>().also { false }
    val isLogin = _isLogin.asImmutable()

    override fun handleIntent(it: UserIntent) {
        super.handleIntent(it)
    }

    fun login(){
        launchWithState {
            userRepository.getUser()
            _isLogin.value = Event(true)
        }
    }
}