package com.rlebron.carrental.utils


import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

object StringDateFomatter {
    fun stringToDate(date: String?): LocalDate {

        var localDate = LocalDate.now()
        val patterns = arrayOf("dd-MM-yy", "dd/MM/yy", "dd-MM-yyyy", "dd/MM/yyyy", "MM-dd-yyyy", "MM/dd/yyyy", "yyyy-MM-dd", "yyyy/MM/dd",
                                            "d-M-yy","d/M/yy","d-M-yyyy","d/M/yyyy","dd-MMMMM-yyyy", "dd/MMMMM/yyyy")

        for (pattern in patterns) {
            try {
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern))
                break
            } catch (e: DateTimeParseException) {
                localDate = LocalDate.now()
            }
        }

        return localDate
    }
}