package com.cbastos.credit_application.Exceptions

data class ExceptionDetails(
    val title: String,
    val status: Int,
    val detail: MutableMap<String, String>,
    val timestamp: Long,
    val developerMessage: String
)
