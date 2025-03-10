package com.cbastos.credit_application.dtos

import com.cbastos.credit_application.entities.Credit
import com.cbastos.credit_application.enums.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode : UUID,
    val creditValue : BigDecimal,
    val numberOfInstallments : Int,
    val status : Status,
    val emailCustomer : String?,
    val incomeCustomer : BigDecimal?
){
    constructor(credit : Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        emailCustomer = credit.customer?.email ?: "",
        incomeCustomer = credit.customer?.income ?: BigDecimal.ZERO
    )
}
