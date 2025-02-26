package com.cbastos.credit_application.repositories

import com.cbastos.credit_application.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository

interface CreditRepository : JpaRepository<Credit, Long> {
}