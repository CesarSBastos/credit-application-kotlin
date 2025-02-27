package com.cbastos.credit_application.services

import com.cbastos.credit_application.entities.Customer

interface ICustomerService {
    fun save(customer: Customer) : Customer
    fun findById(id: Long) : Customer
    fun delete(id: Long)
}