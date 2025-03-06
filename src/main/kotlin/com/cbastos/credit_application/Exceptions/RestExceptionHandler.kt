package com.cbastos.credit_application.Exceptions

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<ExceptionDetails> {
        val errors: MutableMap<String, String> = HashMap()
        exception.bindingResult.allErrors.stream().forEach { error: ObjectError ->
            val fieldName: String = (error as FieldError).field
            val errorMessage: String? = error.getDefaultMessage()
            errors[fieldName] = errorMessage!!
        }
        return ResponseEntity(
            ExceptionDetails(
                title = "Bad Request",
                status = 400,
                detail = errors,
                timestamp = System.currentTimeMillis(),
                developerMessage = exception.message
            ), HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(DataAccessException::class)
    fun handlerMethodArgumentNotValidException(exception: DataAccessException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ExceptionDetails(
                title = "Conflict",
                status = 409,
                detail = mutableMapOf(exception.cause.toString() to exception.message!!),
                timestamp = System.currentTimeMillis(),
                developerMessage = exception.message!!
            )
        )

    }

    @ExceptionHandler(BusinessException::class)
    fun handlerMethodArgumentNotValidException(exception: BusinessException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ExceptionDetails(
                title = "Bad Request",
                status = 400,
                detail = mutableMapOf(exception.cause.toString() to exception.message!!),
                timestamp = System.currentTimeMillis(),
                developerMessage = exception.message
            )
        )

    }

}