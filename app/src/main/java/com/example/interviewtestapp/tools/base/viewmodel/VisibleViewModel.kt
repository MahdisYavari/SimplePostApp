package com.example.interviewtestapp.tools.base.viewmodel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.interviewtestapp.tools.base.mvi.IntentBase
import com.example.interviewtestapp.tools.base.mvi.ViewStateBase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
abstract class VisibleViewModel<TIntent : IntentBase, TState : ViewStateBase> : BaseViewModel() {

    val mviIntent = getIntent()

    protected val _mviState = MutableLiveData<TState>()
    val mviState: LiveData<TState> = _mviState

    init {
        viewModelScope.launch {
            mviIntent.consumeAsFlow().collect {
                handleIntent(it)
            }
        }
    }

    protected open fun handleIntent(it: TIntent) {

    }

    private fun getIntent(): Channel<TIntent> {
        return Channel(Channel.UNLIMITED)
    }

    protected fun <TCustomIntent : IntentBase> getCustomIntent(): Channel<TCustomIntent> {
        return Channel(Channel.UNLIMITED)
    }

    protected fun performActionWithDelay(
        beforeDelayAction: () -> Unit,
        delayAction: () -> Unit = {}
    ) {
        //setIsNotBusy(false)
        beforeDelayAction()
        try {
            Handler().postDelayed({
                delayAction()
                //setIsNotBusy(true)
            }, 1000)
        } catch (exc: java.lang.Exception) {

        }
    }
}