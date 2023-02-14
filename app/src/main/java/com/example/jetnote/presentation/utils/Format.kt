package com.example.jetnote.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String {
    val date = Date(time)
    val simpleFormat = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())
    return simpleFormat.format(date)
}