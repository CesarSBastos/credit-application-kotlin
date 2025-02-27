package com.cbastos.credit_application.services

import com.cbastos.credit_application.entities.Credit
import java.util.*

interface ICreditService {
    fun save(credit: Credit) : Credit
    fun findAllByCustomer(customerId: Long) : List<Credit>
    fun findByCreditCode(customerId: Long,creditCode: UUID) : Credit
}