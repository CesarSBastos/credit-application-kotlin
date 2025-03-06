package com.cbastos.credit_application.dtos

import com.cbastos.credit_application.entities.Customer
import java.math.BigDecimal

data class CustomerView(
    val firstName : String,
    val lasName : String,
    val cpf : String,
    val income : BigDecimal,
    val email : String,
    val zipCode : String,
    val street : String

) {
    constructor(customer : Customer) : this(
        customer.firstName,
        customer.lastName,
        customer.cpf,
        customer.income,
        customer.email,
        customer.address.zipCode,
        customer.address.street
    )
}