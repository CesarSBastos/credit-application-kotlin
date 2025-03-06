package com.cbastos.credit_application.dtos

import com.cbastos.credit_application.entities.Credit
import com.cbastos.credit_application.entities.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Credit value is required")
    val creditValue : BigDecimal,
    @field:Future(message = "First installment date must be in the future")
    val dayFirstInstallment : LocalDate,
    @field:NotNull(message = "Number of installments is required")
    val numberOfInstallments : Int,
    @field:NotNull(message = "Customer id is required")
    val customerId : Long
) {
    fun toEntity() : Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}