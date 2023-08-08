package com.example.interviewtestapp.tools.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import com.example.interviewtestapp.tools.base.viewmodel.BaseViewModel
import com.google.android.material.textfield.TextInputEditText

@SuppressLint("StaticFieldLeak")
object ViewMethod {

    val context: Context = BaseViewModel.activityContext

    fun setDrawable(
        editText: TextInputEditText,
        start: Int,
        top: Int,
        end: Int,
        bottom: Int
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            editText.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)
        }
    }

//    fun setDrawable(
//        textView: MaterialTextView,
//        start: Int,
//        top: Int,
//        end: Int,
//        bottom: Int
//    ) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)
//        }
//    }
//
//    fun setTextColor(component: MaterialTextView, color: Int) {
//        try {
//            val sdk = Build.VERSION.SDK_INT
//            if (sdk < Build.VERSION_CODES.M) {
//                component.setTextColor(context.resources.getColor(color))
//            } else {
//                component.setTextColor(ContextCompat.getColor(context, color))
//            }
//        } catch (e: Exception) {
//        }
//    }
//
//    fun setBackgroundImage(imageView: ImageView, imageId: Int) {
//        val sdk = Build.VERSION.SDK_INT
//        if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
//            imageView.setBackgroundDrawable(ContextCompat.getDrawable(context, imageId))
//        } else {
//            imageView.background = ContextCompat.getDrawable(context, imageId)
//        }
//    }
//
//    fun drawLineOnTextView(textView: MaterialTextView) {
//        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//    }
//
//    fun drawUnderlineTextView(textView: MaterialTextView) {
//        textView.paintFlags = textView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
//    }
}