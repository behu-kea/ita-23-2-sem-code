package com.example.testing

import android.annotation.SuppressLint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun getSum(list: List<Int>): Int {
    return list.sum()
}

@SuppressLint("NewApi")
fun isValidCPR(cpr: String): Boolean {
    if (!cpr.matches(Regex("\\d{6}-\\d{4}"))) {
        return false
    }

    val datePart = cpr.substring(0, 6)
    try {
        // Assuming the CPR number uses the format DDMMYY
        val formatter = DateTimeFormatter.ofPattern("ddMMyy")
        LocalDate.parse(datePart, formatter)
    } catch (e: DateTimeParseException) {
        return false
    }

    return true
}