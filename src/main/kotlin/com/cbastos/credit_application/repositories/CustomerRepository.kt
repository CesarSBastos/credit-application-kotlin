package com.cbastos.credit_application.repositories

import com.cbastos.credit_application.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}