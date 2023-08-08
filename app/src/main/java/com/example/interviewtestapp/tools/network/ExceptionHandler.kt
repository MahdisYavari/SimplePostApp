package com.example.interviewtestapp.tools.network

import com.example.interviewtestapp.R
import com.example.interviewtestapp.tools.base.viewmodel.BaseViewModel
import retrofit2.HttpException

object ExceptionHandler {

    private val context = BaseViewModel.activityContext
//    private var message = ""

//    fun <TModel> getErrorMessage(response: Response<TModel>): String {
//        return try {
//            val errorBody: String = response.errorBody()?.string() ?: ""
//            handleMessage(errorBody)
//        } catch (e: Exception) {
//            getMessage(R.string.action_failed)
//        }
//    }

    fun getErrorMessage(exc: Exception): String {
        return try {
            val httpException: HttpException = exc as HttpException
            val errorBody: String = httpException.response()?.errorBody()?.string()!!
            handleMessage(errorBody)
        } catch (e: Exception) {
            //todo
            ""
//            getMessage(R.string.action_failed)
        }
    }

    private fun handleMessage(errorBody: String): String {
        return when {
            errorBody.contains("Unexpected╪ Error!\",\"Object reference not set to an instance of an object.")
            -> getMessage(R.string.action_failed)
//            errorBody.contains("This Social Security Number exists")
//            -> setObserver(R.string.this_social_security_number_exists, _nationalCode)
            else -> {
                getMessage(R.string.action_failed)
            }
        }
    }

//    private fun setObserver(messageId: Int, liveData: MutableLiveData<Event<String>>): String {
//        message = getMessage(messageId)
//        liveData.value = Event(message)
//        return message
//    }

    private fun getMessage(messageId: Int) = context.getString(messageId)
}