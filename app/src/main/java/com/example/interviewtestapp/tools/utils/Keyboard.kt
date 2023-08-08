package com.example.interviewtestapp.tools.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.example.interviewtestapp.tools.base.viewmodel.BaseViewModel

@SuppressLint("StaticFieldLeak")
object Keyboard {

    private val context: Context = BaseViewModel.activityContext

    fun showKeyboard() {
        try {
            val inputMethodManager =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                0
            )
        } catch (e: Exception) {
        }
    }

    fun hideKeyboard() {
        try {
            val inputMethodManager =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.toggleSoftInput(
                InputMethodManager.HIDE_IMPLICIT_ONLY,
                0
            )
        } catch (e: Exception) {
        }
    }
}

