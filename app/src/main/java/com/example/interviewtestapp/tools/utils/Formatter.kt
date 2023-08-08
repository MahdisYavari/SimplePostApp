package com.example.interviewtestapp.tools.utils

import java.text.DecimalFormat

object Formatter {
    fun formatAsMoney(value: Double): String {
        return DecimalFormat("###,###,###").format(value)
    }

    fun formatAsMoney(value: Int): String {
        return DecimalFormat("###,###,###").format(value)
    }

    fun formatAsQuantity(value: Double): String {
        return DecimalFormat("#.####").format(value)
    }

    fun handleDouble(value: Double): String {
        return DecimalFormat("#.####").format(value)
    }

    fun removeSpace(text: String): String {
        return text.replace("\\s".toRegex(), "")
    }

    fun negativeToPositive(price: Double): Double {
        return Math.abs(price)
    }

    fun positiveToNegative(price: Double): Double {
        return -Math.abs(price)
    }
}
