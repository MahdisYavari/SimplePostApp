package com.example.interviewtestapp.tools.base.viewmodel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.interviewtestapp.tools.network.ExceptionHandler
import com.example.interviewtestapp.tools.network.NetworkHandler
import com.example.interviewtestapp.tools.service.notification.NotificationService
import kotlinx.coroutines.launch

abstract class BaseViewModel(
) : ViewModel() {
    protected abstract val notificationService: NotificationService

    fun launchWithState(action: suspend () -> Unit) =
        performLaunchWithState(
            false,
            true,
            action,
            {}, {})

    fun launchWithState(
        isPerformFinallyActionWithSuccessResponseState: Boolean = false,
        isSendFailedNotification: Boolean = true,
        action: suspend () -> Unit,
        failedAction: suspend () -> Unit = {},
        finallyAction: () -> Unit = {}
    ) = performLaunchWithState(
        isPerformFinallyActionWithSuccessResponseState,
        isSendFailedNotification,
        action,
        failedAction,
        finallyAction
    )

//    fun launchWithState(
//        action: suspend () -> Unit,
//        failedAction: suspend () -> Unit,
//        isSendFailedNotification: Boolean
//    ) =
//        launchWithState(false, isSendFailedNotification, action, failedAction, {})

//    fun launchWithState(
//        isPerformFinallyActionWithSuccessResponseState: Boolean,
//        action: suspend () -> Unit,
//        finallyAction: () -> Unit
//    ) = launchWithState(
//        isPerformFinallyActionWithSuccessResponseState, true, action,
//        {}, finallyAction
//    )

    private fun performLaunchWithState(
        //اگر این فلگ true باشه میاد success بودن ریکوئست چک میکنه و سپس finallyAction اجرا میکنه
        //اگر این فلگ false باشه در همه حال میاد finallyAction اجرا میکنه
        isPerformFinallyActionWithSuccessResponseState: Boolean,
        isSendFailedNotification: Boolean,
        action: suspend () -> Unit,
        failedAction: suspend () -> Unit,
        finallyAction: () -> Unit
    ) {
        when (NetworkHandler.isNetworkAvailable) {
            true -> {
                viewModelScope.launch {
                    var isSuccess = false
                    if (_isNotBusy.value != false) {
                        try {
                            _isNotBusy.value = false
                            action()
                            isSuccess = true
                        } catch (exc: Exception) {
                            if (isSendFailedNotification) {
                                notificationService.showError(ExceptionHandler.getErrorMessage(exc))
                            }
                            failedAction()
                        } finally {
                            _isNotBusy.value = true
                            when (isPerformFinallyActionWithSuccessResponseState) {
                                true -> if (isSuccess) finallyAction()
                                false -> finallyAction()
                            }
                        }
                    }
                }
            }
            false -> {
                //todo
//                ApplicationActivity.networkDialog?.dialog?.show()
            }
        }
    }

    protected fun sendInformationMessage(messageId: Int) {
        notificationService.showInformation(
            activityContext.getString(
                messageId
            )
        )
    }

    protected fun sendErrorMessage(messageId: Int) {
        notificationService.showError(
            activityContext.getString(
                messageId
            )
        )
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var activityContext: AppCompatActivity
        private val _isNotBusy = MutableLiveData(true)
        fun isNotBusy(): Boolean = _isNotBusy.value ?: true
    }
}
