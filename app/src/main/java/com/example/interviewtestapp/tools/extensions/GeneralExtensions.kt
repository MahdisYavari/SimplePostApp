package com.example.interviewtestapp.tools.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

typealias Mapper<T, U> = (@JvmSuppressWildcards T) -> U

fun <T> MutableLiveData<T>.asImmutable(): LiveData<T> {
    return this
}